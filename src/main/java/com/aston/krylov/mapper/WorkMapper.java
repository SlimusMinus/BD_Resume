package com.aston.krylov.mapper;

import com.aston.krylov.dto.WorkDTO;
import com.aston.krylov.entity.Work;

import java.util.ArrayList;
import java.util.List;

public class WorkMapper {

    public static List<WorkDTO> toDTO(List<Work> work) {
        if (work == null) {
            return null;
        }

        List<WorkDTO> workDTOList = new ArrayList<>();
        for (Work item : work) {
            WorkDTO dto = new WorkDTO();
            dto.setName(item.getName());
            dto.setStartDate(item.getStartDate());
            dto.setEndDate(item.getEndDate());
            dto.setResponsibilities(item.getResponsibilities());
            workDTOList.add(dto);
        }
        return workDTOList;
    }

}
