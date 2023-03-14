package com.tms.kulinar.service;


import com.tms.kulinar.Mappers.FeedbackMapper;
import com.tms.kulinar.domain.Feedback;
import com.tms.kulinar.exception.FeedbackNotFoundException;
import com.tms.kulinar.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;

@Service
public class FeedbackService {
    public FeedbackRepository feedbackRepository;
    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback getFeedbackById(int id) {
        return feedbackRepository.getFeedbackById(id);
    }

    public ArrayList<Feedback> getAllFeedback() {
        return feedbackRepository.getAllFeedback();

    }

    public void createFeedback(Feedback feedback) {
       feedbackRepository.createFeedback(feedback);
    }

    public void updateFeedbackById(Feedback feedback) {
        feedbackRepository.updateFeedback(feedback);
    }

    public void deleteFeedback(Feedback feedback) {
        feedbackRepository.deleteFeedback(feedback);
    }
}
