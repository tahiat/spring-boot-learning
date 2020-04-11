package com.example.spring_starter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
//    private List<Topic> topics = new ArrayList( Arrays.asList(
//                new Topic("spring", "spring framework", "spring framework description"),
//                new Topic("java", "java core", "java core description"),
//                new Topic("machine learning","machine learning primary","learning machine")
//    ));

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics () {
        //return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
          return topicRepository.findById(id).get();
//        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic (Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic (String id, Topic topic) {
        topicRepository.save(topic);
//        for (int i = 0; i < topics.size(); i++) {
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)){
//                topics.set(i, topic);
//                return;
//            }
//        }
    }

    public void deleteTopic (String id) {
        topicRepository.deleteById(id);
//        topics.removeIf(topic -> topic.getId().equals(id));
    }
}
