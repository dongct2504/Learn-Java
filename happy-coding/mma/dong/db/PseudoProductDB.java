package dong.db;

import dong.business.Book;
import dong.business.Software;
import dong.business.Album;
import dong.business.Product;

public class PseudoProductDB {

	public static Product getProduct(String productCode) {
		// In a more realistic application, this code would
		// get the data for the product from a file or database
		// For now, this code just uses if/else statements
		// to return the correct product data
		
		Product product = null;
		
		if (productCode.equalsIgnoreCase("java")
				|| productCode.equalsIgnoreCase("jsp")
				|| productCode.equalsIgnoreCase("mysql")) {
			Book book = new Book();
			if (productCode.equalsIgnoreCase("java")) {
				book.setCode(productCode);
				book.setDescription("Murach's Java Programming");
				book.setPrice(57.50);
				book.setAuthor("Dong");
			} else if (productCode.equalsIgnoreCase("jsp")) {
				book.setCode(productCode);
				book.setDescription("Murach's Java Servlets and JSP");
				book.setPrice(57.50);
				book.setAuthor("Mike Urban");
			} else if (productCode.equalsIgnoreCase("mysql")) {
				book.setCode(productCode);
				book.setDescription("Murach's MySQL");
				book.setPrice(54.50);
				book.setAuthor("Joel Murach");
			}

			product = book;
		} else if (productCode.equalsIgnoreCase("eclipse")) {
			Software software = new Software();
			software.setCode(productCode);
			software.setDescription("Eclipse");
			software.setPrice(399);
			software.setVersion("1.1.5");

			product = software;
		} else if (productCode.equalsIgnoreCase("sgtp")) {
			Album album = new Album();
      album.setCode("sgtp");
      album.setDescription("Sgt. Peppers Lonely Hearts Club Band");
      album.setPrice(14.99);
      album.setArtist("The Beatles");

      product = album; // set Product object equal to the Software object		}
		}

		return product;
	}
}
