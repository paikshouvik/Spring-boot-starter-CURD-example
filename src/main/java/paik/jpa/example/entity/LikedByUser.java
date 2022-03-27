package paik.jpa.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LikedByUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long likedByUserId;
	
	String likedByName;

	@Override
	public String toString() {
		return "LikedByUser [likedByUserId=" + likedByUserId + ", likedByName=" + likedByName + "]";
	}

	public Long getLikedByUserId() {
		return likedByUserId;
	}

	public void setLikedByUserId(Long likedByUserId) {
		this.likedByUserId = likedByUserId;
	}

	public String getLikedByName() {
		return likedByName;
	}

	public void setLikedByName(String likedByName) {
		this.likedByName = likedByName;
	}
	
	
}
