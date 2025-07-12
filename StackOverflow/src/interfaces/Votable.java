package interfaces;

import entities.User;
import enums.VoteType;

public interface Votable {
    void vote(User voter, VoteType voteType);
    int getVoteCount();
}
