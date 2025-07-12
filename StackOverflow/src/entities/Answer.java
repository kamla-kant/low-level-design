package entities;

import enums.VoteType;
import interfaces.Commentable;
import enums.ReputationType;
import interfaces.Votable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class Answer implements Commentable, Votable {
    private String id;
    private String content;
    private boolean isAccepted;
    private LocalDate creationDate;
    private User author;
    private Question question;
    private List<Comment> comments;
    private List<Vote> votes;

    public Answer(User author, Question question, String content) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.creationDate = LocalDate.now();
        this.author = author;
        this.question = question;
        this.comments = new CopyOnWriteArrayList<>();
        this.votes = new CopyOnWriteArrayList<>();
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
        votes.removeIf(v-> v.getVoter().equals(voter));
        votes.add(new Vote(voter, voteType));
        author.updateReputation(voteType.equals(VoteType.UPVOTE)
                ? ReputationType.ANSWER_UPVOTE.getPoints()
                : ReputationType.ANSWER_DOWNVOTE.getPoints());
    }

    @Override
    public int getVoteCount() {
        return votes
                .stream()
                .mapToInt(v-> v.getType().getValue())
                .sum();
    }

    public void markAsAccepted() {
        if (isAccepted) {
            throw new IllegalStateException("This answer is already accepted");
        }
        isAccepted = true;
        author.updateReputation(ReputationType.ANSWER_ACCEPTED.getPoints());
    }

    public String getId() {
        return id;
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

    public Question getQuestion() {
        return question;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public boolean isAccepted() {
        return isAccepted;
    }
}
