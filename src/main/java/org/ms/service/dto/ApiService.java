package org.ms.service.dto;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class ApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiService.class);
    
    @Autowired
    private  RestTemplate restTemplate;

	public Optional<String> getPersonnesAssurees(MultipartFile[] files) {
        String url= "http://localhost:1920/v2/employees/evenements/societaires/documents";
        return restCall(url,files, new ParameterizedTypeReference<String>() {
            // Nothing
        }, files);
    }

    private <T> Optional<String> restCall(String url,MultipartFile[] files, ParameterizedTypeReference<T> responseType, Object... params) {
        LOGGER.debug("Try to call an api. url={} | params={}", url, params);
        final HttpHeaders headers = new HttpHeaders();
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
        Arrays.stream(files).forEach(file -> { bodyMap.add("fichiers", file); });
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);
        String response = restTemplate.exchange(url,
                HttpMethod.POST, requestEntity, String.class).getBody();
        return Optional.ofNullable(response);
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
    
}
