/**
 * 
 */
package com.x2bee.demo.app.repository.x2bee;

import java.util.List;

import com.x2bee.demo.app.dto.Sample2;

/**
 * @author choiyh44
 * @version 1.0
 * @since 2021. 9. 8.
 *
 */
public interface Sample2Mapper {
    public List<Sample2> selectAllSampleList();
    public void insert(Sample2 sample2);
}
