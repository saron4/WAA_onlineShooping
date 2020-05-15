package com.group3.onlineShooping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Getter
@Setter

@Entity
public class Review {
	/*public enum ReviewStatus {
		Created,
		approved,
	}*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reviewId;

	@ManyToOne
	@JoinColumn(name="buyer_id")
	private Buyer buyer ;

	@ManyToOne
	@JoinColumn(name="product_id")
	 private Product product ;

	@NotBlank(message = "comment can't empty!")
	private String comment ;


	@Enumerated(EnumType.STRING)
	private ReviewStatus  reviewStatus = ReviewStatus.Created;

	@Column(name = "comment_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime commentTime = LocalDateTime.now();

	@Override
	public String toString() {
		return "Review{" +
				"reviewId=" + reviewId +
				", comment='" + comment + '\'' +
				'}';
	}
}
