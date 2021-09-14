/**
 * 
 */
package com.x2bee.demo.app.service;

import java.util.List;

import com.x2bee.demo.app.dto.Sample;
import com.x2bee.demo.app.dto.Sample2;

/**
 * @author choiyh44
 * @version 1.0
 * @since 2021. 9. 8.
 *
 */
public interface SampleService {
    public List<Sample> getAllSampleList();
    public List<Sample2> getAllSample2List();
    public void insertSample2 (Sample2 sample2);
    /**
     * @param sample2
     */
    public void insertSample2Multi(Sample2 sample2) throws Exception;
}
