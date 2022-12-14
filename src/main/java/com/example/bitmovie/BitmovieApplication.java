package com.example.bitmovie;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableScheduling //스케줄링 기능 활성화
@ComponentScan({"data.*"})
@MapperScan({"data.*"})
public class BitmovieApplication implements Jackson2ObjectMapperBuilderCustomizer {

    public static void main(String[] args) {
        SpringApplication.run(BitmovieApplication.class, args);
    }

    @Override
    public void customize(Jackson2ObjectMapperBuilder builder) {
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTimeSerializer local_serializer = new LocalDateTimeSerializer(formatter);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssZ");
        CustomOffsetDateTimeSerializer offset_serializer = new CustomOffsetDateTimeSerializer(formatter2);

        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateSerializer local_date_serializer = new LocalDateSerializer(formatter3);

        builder
                .simpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .serializerByType(LocalDateTime.class,local_serializer)
                .serializerByType(OffsetDateTime.class,offset_serializer);

        builder
                .simpleDateFormat("yyyy-MM-dd")
                .serializerByType(LocalDate.class,local_date_serializer);
    }
    
    public class CustomOffsetDateTimeSerializer extends OffsetDateTimeSerializer {
        public CustomOffsetDateTimeSerializer(DateTimeFormatter formatter) {

            super(OffsetDateTimeSerializer.INSTANCE, false, formatter);

        }

    }
}
