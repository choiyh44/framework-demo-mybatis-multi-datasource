/**
 * 
 */
package com.x2bee.demo.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.x2bee.demo.app.dto.Sample;
import com.x2bee.demo.app.dto.Sample2;
import com.x2bee.demo.app.service.SampleService;

import lombok.RequiredArgsConstructor;

/**
 * @author choiyh44
 * @version 1.0
 * @since 2021. 9. 8.
 *
 */
@RestController
@RequestMapping("/api/samples")
@RequiredArgsConstructor
public class SampleController {
    public final SampleService sampleService;
    
    @GetMapping("/sample")
    public List<Sample> getAllSampleList() {
        return sampleService.getAllSampleList();
    }

    @GetMapping("/sample2")
    public List<Sample2> getAllSample2List() {
        return sampleService.getAllSample2List();
    }

    @PostMapping("/sample2")
    public void insertSample2(@RequestBody Sample2 sample2) {
        sampleService.insertSample2(sample2);
    }

    @PostMapping("/sample2/multi")
    public void insertSample2Multi(@RequestBody Sample2 sample2) throws Exception {
        sampleService.insertSample2Multi(sample2);
    }

}
