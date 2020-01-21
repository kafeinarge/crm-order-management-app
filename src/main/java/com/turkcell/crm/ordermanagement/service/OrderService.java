package com.turkcell.crm.ordermanagement.service;

import com.google.gson.Gson;
import com.turkcell.crm.ordermanagement.dto.OrderDTO;
import com.turkcell.crm.ordermanagement.entity.Order;
import com.turkcell.crm.ordermanagement.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.parser.ParseException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Service
@Slf4j
public class OrderService {

    @Value("${kafka-client-id}")
    private String kafkaClientId;

    @Value("${kafka-bootstrap-servers}")
    private String kafkaBootstrapServers;

    @Value("${kafka-producer-key-serializer}")
    private String kafkaProducerKeySerializer;

    @Value("${kafka-producer-value-serializer}")
    private String kafkaProducerValueSerializer;

    @Value("${kafka-order-topic}")
    private String kafkaOrderTopic;

    final
    OrderMapper orderMapper;

    final
    StaticIpProvider staticIpProvider;

    public OrderService(OrderMapper orderMapper, StaticIpProvider staticIpProvider) {
        this.orderMapper = orderMapper;
        this.staticIpProvider = staticIpProvider;
    }

    /**
     * order has been received and an available mocking staticIP set to order.
     * @param orderDTO
     * @throws IOException
     * @throws ParseException
     */
    public void save(OrderDTO orderDTO) throws IOException, ParseException {
        Order order = orderMapper.toEntity(orderDTO);
        String availableStaticIP = staticIpProvider.retrieveAvailableStaticIP();
        order.setStaticIP(availableStaticIP);

        String topicName = kafkaOrderTopic;

        Producer producer = createProducer();

        Gson gson = new Gson();
        String orderJsonToKafka = gson.toJson(order);

        ProducerRecord<String, String> rec = new ProducerRecord<>(
                topicName, orderJsonToKafka);
        try {
            producer.send(rec);
        }
        catch (Exception e){
            log.error("Order cannot send data successfully");
            throw new KafkaException();
        }
        producer.close();

        log.info("Order has sent to Kafka succesfully");
    }

    /**
     * returns producer using kafka properties
     *
     * @return
     */
    public Producer createProducer() {
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.CLIENT_ID_CONFIG, kafkaClientId);
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                kafkaBootstrapServers);
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                kafkaProducerKeySerializer);
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                kafkaProducerValueSerializer);

        return new KafkaProducer<String, String>(configProperties);
    }
}
