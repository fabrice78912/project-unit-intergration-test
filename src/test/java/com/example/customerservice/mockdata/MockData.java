package com.example.customerservice.mockdata;


import com.example.customerservice.dto.CustomerDTO;
import com.example.customerservice.entities.Customer;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.testcontainers.shaded.org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static List<Customer> getCustomers() throws IOException {
        InputStream inputStream = Resources.getResource("customers.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Customer>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

    public static List<CustomerDTO> getCustomersDto() throws IOException {
        InputStream inputStream = Resources.getResource("customers.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

    public static  <T> List<T> getCustomerType(TypeToken<ArrayList<T>> typeToken ) throws IOException {
        InputStream inputStream = Resources.getResource("customers.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = typeToken.getType();
        return new Gson().fromJson(json, listType);
    }

}
