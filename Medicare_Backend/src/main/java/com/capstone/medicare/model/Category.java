package com.capstone.medicare.model;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
public class Category 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categoryId")
	private long categoryId;
	
	@Column(name="categoryName")
	private String categoryName;
	
	@Column(name="categoryDesc")
	private String categoryDesc;

	/* @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "category")
	 private Set<Product> produtitems= new HashSet<>();
	 */

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	/*public Set<Product> getProdutitems() {
		return produtitems;
	}

	public void setProdutitems(Set<Product> produtitems) {
		this.produtitems = produtitems;
	}*/

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDesc="
				+ categoryDesc +  "]";
	}
	
}