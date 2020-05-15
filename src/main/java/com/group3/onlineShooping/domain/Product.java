package com.group3.onlineShooping.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

	@Size(min = 4, max = 100, message = "{Size.validation}")
	private String productNumber;

	@Size(min = 4, max = 100, message = "{Size.validation}")
	private String title;

	@Size(min = 4, max = 100, message = "{Size.validation}")
	private String summary;

	@Size(min = 4, max = 200, message = "{Size.validation}")
	private String description;
	@NotNull
	private BigDecimal price;


	private boolean isAvailable = true;

	@NotNull
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
