package com.example.feedbackservice.repository;

import com.example.feedbackservice.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeedbackRepository extends JpaRepository<Feedback,Integer> {
}
