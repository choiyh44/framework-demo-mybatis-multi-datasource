/**
 * 
 */
package com.x2bee.demo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.x2bee.demo.app.dto.Sample;
import com.x2bee.demo.app.dto.Sample2;
import com.x2bee.demo.app.repository.x2bee.Sample2Mapper;
import com.x2bee.demo.app.repository.x2commerce.SampleMapper;

import lombok.RequiredArgsConstructor;

/**
 * @author choiyh44
 * @version 1.0
 * @since 2021. 9. 8.
 *
 */
@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {
    private final SampleMapper sampleMapper;
    private final Sample2Mapper sample2Mapper;
    
    public List<Sample> getAllSampleList() {
        return sampleMapper.selectAllSampleList();
    }
    
    public List<Sample2> getAllSample2List() {
        return sample2Mapper.selectAllSampleList();
    }
    
    public void insertSample2 (Sample2 sample2) {
        sample2Mapper.insert(sample2);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class, transactionManager = "db2TxManager")
    public void insertSample2Multi(Sample2 sample2) throws Exception {
        sample2Mapper.insert(sample2);
        sample2Mapper.insert(sample2);
        if (true) {
            throw new Exception("transaction stopped.");
        }
        sample2Mapper.insert(sample2);
        
    }
    
}
