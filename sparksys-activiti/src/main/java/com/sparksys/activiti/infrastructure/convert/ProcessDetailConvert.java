package com.sparksys.activiti.infrastructure.convert;

import com.sparksys.activiti.infrastructure.entity.ProcessDetail;
import com.sparksys.activiti.interfaces.dto.process.ProcessDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * description: ProcessTaskRule 对象Convert
 *
 * @author zhouxinlei
 * @date 2020-06-05 21:28:06
 */
@Mapper
public interface ProcessDetailConvert {

    ProcessDetailConvert INSTANCE = Mappers.getMapper(ProcessDetailConvert.class);

    /**
     * ProcessDetail 转换为 ProcessDetailDTO
     *
     * @param processDetail 流程详细
     * @return ProcessDetailDTO
     */
    ProcessDetailDTO convertProcessDetailDTO(ProcessDetail processDetail);

}
