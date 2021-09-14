/**
 * 
 */
package com.x2bee.demo.app.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author choiyh44
 * @version 1.0
 * @since 2021. 9. 8.
 *
 */
@Getter
@Setter
@ToString
@Alias("Sample2")
public class Sample2 {
    private Long id;
    private String name;
    private String description;
}
