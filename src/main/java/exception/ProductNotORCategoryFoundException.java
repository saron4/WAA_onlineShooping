package exception;

public class ProductNotORCategoryFoundException extends RuntimeException {

	private static final long serialVersionUID = 3935230281455340039L;

	private String categoryId;

	public ProductNotORCategoryFoundException(String categoryId) {
		this. categoryId= categoryId;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
}
