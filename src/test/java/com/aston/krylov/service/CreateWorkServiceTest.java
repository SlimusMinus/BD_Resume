package com.aston.krylov.service;

import com.aston.krylov.entity.Work;
import com.aston.krylov.repository.SaveWork;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class CreateWorkServiceTest {
    @Mock
    private SaveWork saveWork;

    @InjectMocks
    private CreateWorkService createWorkService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateResumeWithNonNullResume() {
        // ������� ��������� Resume
        Work work = new Work();
        // ������������� ����������� ��������

        // �������� ����� createResume
        createWorkService.createWork(work);

        // ���������, ��� ����� save ��� ������ � ���������� ����������
        verify(saveWork).save(work);
    }
}