package com.myprojects.kursspring.services;

import com.myprojects.kursspring.domain.Quest;
import com.myprojects.kursspring.repositories.QuestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestServiceTest {

    @Mock
    QuestRepository questRepository;

    @Test
    public void getAllNotStartedQuests() {
        Quest q1 = new Quest(1,"T1");
        Quest q2 = new Quest(2,"T2");
        Quest q3 = new Quest(3,"T3");

        List<Quest> allQuestsList = new ArrayList<>();

        q2.setStarted(true);

        allQuestsList.add(q1);
        allQuestsList.add(q2);
        allQuestsList.add(q3);

        when(questRepository.getAll()).thenReturn(allQuestsList);

        QuestService questService = new QuestService();
        questService.setQuestRepository(questRepository);

        List<Quest> notStartedQuest = questService.getAllNotStartedQuests();

        assertEquals(2, notStartedQuest.size());
        assertThat(notStartedQuest, containsInAnyOrder(q1, q3));
    }
}