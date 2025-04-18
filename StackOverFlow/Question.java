
import java.util.*;

// import javax.swing.text.html.HTML.Tag;

public class Question implements Votable, Commentable {

    private final int id;
    private final String title;
    private final String content;
    private final User author;
    private final Date creationDate;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List<Tag> tags;
    private final List<Vote> votes;

    public Question(User author, String title, String content, List<String> tagsnames) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.id = generateId();
        this.creationDate = new Date();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.votes = new ArrayList<>();

        for (String tag : tagsnames) {
            this.tags.add(new Tag(tag));
        }
    }

    public void addAnswer(Answer answer) {
        if (!answers.contains(answer)) {
            answers.add(answer);
        }
    }

    @Override
    public void vote(User user, int val) {
        if (val != 1 && val != -1) {
            throw new IllegalAccessException("The Vote value should be 1 or -1");
        }
        votes.removeIf(v -> v.getUser().equals(user));
        votes.add(new Vote(user, val));
        author.updateReputation(val * 5);
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    // Getters
    public int getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public List<Answer> getAnswers() {
        return new ArrayList<>(answers);
    }

    public List<Tag> getTags() {
        return new ArrayList<>(tags);
    }

}
