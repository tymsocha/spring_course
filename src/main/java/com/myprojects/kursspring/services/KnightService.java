package com.myprojects.kursspring.services;

import com.myprojects.kursspring.domain.Knight;
import com.myprojects.kursspring.domain.PlayerInformation;
import com.myprojects.kursspring.repositories.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KnightService {

    @Autowired
    KnightRepository repository;

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
        int rewardSum = repository.getAllKnights().stream()
                .filter(knight -> knight.getQuest().isCompleted())
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();

        repository.getAllKnights().stream()
                .filter(knight -> knight.getQuest().isCompleted())
                .forEach(knight -> {
                    knight.setQuest(null);
                });

        return rewardSum;
    }
}
