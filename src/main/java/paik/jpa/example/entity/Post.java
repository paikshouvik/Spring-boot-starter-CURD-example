package paik.jpa.example.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long postId;
	private Long userId;
	private String userName;
	private String description;

	@OneToMany(targetEntity = LikedByUser.class, mappedBy = "likedByUserId")
	private List<LikedByUser> like;

	@OneToMany(targetEntity = Comments.class, mappedBy = "commentId")
	private List<Comments> comments;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public List<LikedByUser> getLike() {
		return like;
	}

	public void setLike(List<LikedByUser> like) {
		this.like = like;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", userId=" + userId + ", userName=" + userName + ", description="
				+ description + ", like=" + like + ", comments=" + comments + "]";
	}

	

}
