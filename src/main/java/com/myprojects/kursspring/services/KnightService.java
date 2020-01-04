package com.myprojects.kursspring.services;

import com.myprojects.kursspring.domain.Knight;
import com.myprojects.kursspring.domain.PlayerInformation;
import com.myprojects.kursspring.repositories.KnightRepository;
import com.myprojects.kursspring.repositories.PlayerInformationRepository;
import com.myprojects.kursspring.repositories.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class KnightService {

    @Autowired
    KnightRepository repository;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Autowired
    QuestRepository questRepository;

    public List<Knight> getAllKnights() {
        return new ArrayList<>(repository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        repository.createKnight(knight.getName(), knight.getAge());
    }

    public Knight getKnight(Integer id) {
        return repository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        repository.removeKnight(id);
    }

    public void updateKnight(Knight knight) {
        repository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() {

        Predicate<Knight> knightPredicate = knight -> {
            if (knight.getQuest() != null) {
                return knight.getQuest().isCompleted();
            } else return false;
        };

        int rewardSum = repository.getAllKnights().stream()
                .filter(knightPredicate)
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();

        repository.getAllKnights().stream()
                .filter(knightPredicate)
                .forEach(knight -> {
                    knight.setQuest(null);
                });

        return rewardSum;
    }

    @Transactional
    public void getMyGold() {
        List<Knight> allKnights = getAllKnights();
        allKnights.forEach(knight -> {
            if (knight.getQuest() != null) {
                boolean completed = knight.getQuest().isCompleted();
                if (completed) {
                    questRepository.update(knight.getQuest());
                }
            }
        });

        PlayerInformation playerInformation = playerInformationRepository.getFirst();
        int currentGold = playerInformation.getGoldAmount();
        playerInformation.setGoldAmount(currentGold + collectRewards());
    }
}
