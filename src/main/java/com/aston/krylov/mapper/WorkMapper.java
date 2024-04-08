package com.aston.krylov.mapper;

import com.aston.krylov.dto.WorkDTO;
import com.aston.krylov.entity.Work;

import java.util.List;

public class WorkMapper {

    public static WorkDTO toDTO(Work work) {
        if (work == null) {
            return null;
        }
        WorkDTO dto = new WorkDTO();
        dto.setName(work.getName());
        dto.setStartDate(work.getStartDate());
        dto.setEndDate(work.getEndDate());
        dto.setResponsibilities(work.getResponsibilities());
        return dto;
    }

    public static Work fromDTO(WorkDTO workDTO) {
        if (workDTO == null) {
            return null;
        }

        Work work = new Work();
        work.setName(workDTO.getName());
        work.setStartDate(workDTO.getStartDate());
        work.setEndDate(workDTO.getEndDate());
        work.setResponsibilities(workDTO.getResponsibilities());

        return work;
    }
}
