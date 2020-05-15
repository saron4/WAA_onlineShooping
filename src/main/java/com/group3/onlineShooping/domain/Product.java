package com.group3.onlineShooping.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String productNumber;

	private String title;

	private String summary;

	private String description;

	private BigDecimal price;

	private boolean isAvailable = true;

	private long availableInStor;

	@Transient
	private long cartQuantity;

	@Transient
	private MultipartFile productImage;

	@ManyToOne
	@JoinColumn(name = "product_category")
	private Category category;

	@OneToOne
	private Seller seller;


	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Review> reviewsProduct;


}
