package entities;

import enums.VoteType;
import interfaces.Commentable;
import enums.ReputationType;
import interfaces.Votable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class Question implements Commentable, Votable {
    private String id;
    private String title;
    private String content;
    private LocalDate creationDate;
    private User author;
    private List<Answer> answers;
    private List<Comment> comments;
    private List<Tag> tags;
    private List<Vote> votes;
    private Answer acceptedAnswer;

    public Question(User author, String title, String content, List<Tag> tags) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
        this.creationDate = LocalDate.now();
        this.author = author;
        this.answers = new CopyOnWriteArrayList<>();
        this.comments = new CopyOnWriteArrayList<>();
        this.votes = new CopyOnWriteArrayList<>();
        this.tags = tags;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void vote(User voter, VoteType voteType) {
        votes.removeIf(v -> v.getVoter().equals(voter));
        votes.add(new Vote(voter, voteType));
        author.updateReputation(voteType.equals(VoteType.UPVOTE)
                ? ReputationType.QUESTION_UPVOTE.getPoints()
                : ReputationType.QUESTION_DOWNVOTE.getPoints());
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
    }

    public void acceptAnswer(Answer answer){
        acceptedAnswer=answer;
    }

    public List<Answer> getAnswers(){
        return answers;
    }

    @Override
    public int getVoteCount() {
        return votes
                .stream()
                .mapToInt(v-> v.getType().getValue())
                .sum();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public User getAuthor() {
        return author;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }
}
