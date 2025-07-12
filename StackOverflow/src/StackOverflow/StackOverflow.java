package StackOverflow;

import entities.*;
import enums.VoteType;
import interfaces.Commentable;
import interfaces.Votable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverflow {
    private static StackOverflow instance;
    private Map<String, User> users;
    private Map<String, Question> questions;
    private Map<String, Answer> answers;
    private Map<String, Tag> tags;

    private StackOverflow() {
        users = new ConcurrentHashMap<>();
        questions = new ConcurrentHashMap<>();
        answers = new ConcurrentHashMap<>();
        tags = new ConcurrentHashMap<>();
    }

    public static StackOverflow getInstance() {
        if (instance == null) {
            instance = new StackOverflow();
        }
        return instance;
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getUserId(), user);
        return user;
    }

    public Question postQuestion(String userId, String title, String content, List<String> questionTags) {
        User author = users.get(userId);
        List<Tag> tagList = new ArrayList<>();
        for (String qTag : questionTags) {
            Tag tag = new Tag(qTag);
            tagList.add(tag);
        }
        Question question = new Question(author, title, content, tagList);
        questions.put(question.getId(), question);
        return question;
    }

    public Answer postAnswer(String userId, String questionId, String content) {
        User author = users.get(userId);
        Question question = questions.get(questionId);
        Answer answer = new Answer(author, question, content);
        question.addAnswer(answer);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public Comment addComment(String userId, Commentable commentable, String content) {
        User author = users.get(userId);
        Comment comment = new Comment(author, content);
        commentable.addComment(comment);
        return comment;
    }

    public void vote(String userId, Votable votable, VoteType voteType) {
        User voter = users.get(userId);
        votable.vote(voter, voteType);
    }

    public void acceptAnswer(String answerId) {
        Answer answer = answers.get(answerId);
        Question question = answer.getQuestion();
        answer.markAsAccepted();
        question.acceptAnswer(answer);
    }

    public List<Question> searchQuestions(String query) {
        return questions.values().stream()
                .filter(question -> question.getTitle().toLowerCase().contains(query.toLowerCase())
                        || question.getContent().toLowerCase().contains(query.toLowerCase())
                        || question.getTags().stream()
                        .anyMatch(tag -> tag.getTagName().toLowerCase().contains(query.toLowerCase())))
                .collect(Collectors.toList());
    }

    public List<Question> getQuestionsByUser(String userid){
        return questions.values().stream()
                .filter(question -> question.getAuthor().getUserId().equals(userid))
                .collect(Collectors.toList());
    }
}
