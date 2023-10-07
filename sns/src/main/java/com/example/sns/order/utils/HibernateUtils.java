package com.example.sns.order.utils;

import com.example.sns.order.domain.Post;
import lombok.Getter;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import java.util.EnumSet;
import java.util.Properties;


public class HibernateUtils {
    @Getter
    private static final StandardServiceRegistry serviceRegistry;
    static {
        Properties properties = new Properties();

        // Example properties
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.connection.driver_class", "org.h2.Driver");
        properties.put("hibernate.connection.url", "jdbc:h2:mem:testdb");
        properties.put("hibernate.connection.username", "sa");
        properties.put("hibernate.connection.password", "password");
        // ... add more properties as needed

        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();
    }

    public static void generateSchema() {
        MetadataSources metadataSources = new MetadataSources(HibernateUtils.getServiceRegistry());
        metadataSources.addAnnotatedClass(Post.class);
        Metadata metadata = metadataSources.buildMetadata();

        SchemaExport schemaExport = new SchemaExport();
        schemaExport.setFormat(true);
        schemaExport.setOutputFile("create.sql");
        schemaExport.createOnly(EnumSet.of(TargetType.SCRIPT), metadata);
    }


}
