package com.aston.krylov.service;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.repository.CreateAndUpdateRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class CreateResumeServiceTest {

    @Mock
    private CreateAndUpdateRepositoryInterface saveResume;

    @InjectMocks
    private CreateAndUpdateService createResumeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateResumeWithNonNullResume() {
        // ������� ��������� Resume
        Resume resume = new Resume();
        // ������������� ����������� ��������

        // �������� ����� createResume
        createResumeService.createResume(resume);

        // ���������, ��� ����� save ��� ������ � ���������� ����������
        verify(saveResume).saveResume(resume);
    }
}