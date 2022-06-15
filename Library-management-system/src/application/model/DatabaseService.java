package application.model;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import application.entry.Authors;
import application.entry.Books;
import application.entry.Borrows;
import application.entry.Categories;
import application.entry.Librarians;
import application.entry.Members;
import application.entry.Users;

public class DatabaseService {

	public static List<Categories> findAllCategories() {
		
		List<Categories> list = new ArrayList<>();
		try(Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM categories";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Categories cate = new Categories();
				cate.setId(rs.getInt("id"));
				cate.setName(rs.getString("name"));
				list.add(cate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void saveCategory(String name) {
		try(var con = MyConnection.getConnection()) {
			String query = "INSERT INTO categories( name ) VALUES ( ?)";
			var pstm = con.prepareStatement(query);
			
			pstm.setString(1, name);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void deleteWithId(int id) {
		try(Connection con = MyConnection.getConnection()) {
			String query = "DELETE FROM categories WHERE id = ?";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void updateCategoryName(Categories category) {
		
		try(var con = MyConnection.getConnection()) {
			String query = "UPDATE categories SET name = ? WHERE id= ?";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, category.getName());
			pstm.setInt(2, category.getId());
			
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public static List<Authors> findAllAuthors() {
		List<Authors> list = new ArrayList<>();
		try(var con = MyConnection.getConnection()) {
			String query = "SELECT * FROM authors";
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while(rs.next()) {
				Authors author = new Authors();
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				author.setCity(rs.getString("city"));
				author.setBirthday(LocalDate.parse(rs.getString("birthday")));
				list.add(author);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void saveAuthors(String name, String city, LocalDate birthday) {
		try(var con = MyConnection.getConnection()) {
			String query = "INSERT INTO authors (name , city, birthday) VALUES (?, ?, ?)";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setString(2, city);
			pstm.setDate(3, Date.valueOf(birthday));
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void deleteWithAuthorId(int id) {
		try(var con = MyConnection.getConnection()) {
			String query = "DELETE FROM authors WHERE id = ?";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void UpdateAuthors(Authors author) {
		try(var con = MyConnection.getConnection()) {
			String query = "UPDATE authors SET name = ? , city = ? , birthday = ? WHERE id = ?";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, author.getName());
			pstm.setString(2, author.getCity());
			pstm.setDate(3, Date.valueOf(author.getBirthday()));
			pstm.setInt(4, author.getId());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static boolean saveBooks(Books book) {
		boolean result = false;
		try(var con = MyConnection.getConnection()) {
			String query = "INSERT INTO books (code, title, category_id, author_id) VALUES (?, ?, ?, ?)";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, book.getCode());
			pstm.setString(2, book.getTitle());
			pstm.setInt(3, book.getCategory().getId());
			pstm.setInt(4, book.getAuthor().getId());
			pstm.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Books findBookByCode(String code) {
		Books book = null;
		try(var con = MyConnection.getConnection()) {
			String query = """
					SELECT b.*, a.name 'author', c.name 'category'  FROM 
					books b, authors a, categories c
					WHERE b.author_id = a.id AND
					b.category_id = c.id AND b.code = ?
					""";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, Integer.parseInt(code));
			var rs  = pstm.executeQuery();
			while(rs.next()) {
				book = new Books();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				
				Authors auth = new Authors();
				auth.setId(rs.getInt("author_id"));
				auth.setName(rs.getString("author"));
				book.setAuthor(auth);
				
				Categories cate = new Categories();
				cate.setId(rs.getInt("category_id"));
				cate.setName(rs.getString("category"));
				book.setCategory(cate);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	public static boolean updateBooks(Books book) {
		try(var con = MyConnection.getConnection()) {
			String query = "UPDATE books SET  title= ?, author_id = ?, category_id = ? WHERE code = ?";
			var pstm = con.prepareStatement(query);
			
			pstm.setString(1, book.getTitle());
			pstm.setInt(2, book.getAuthor().getId());
			pstm.setInt(3, book.getCategory().getId());
			pstm.setInt(4, book.getCode());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<Members> findAllMembers() {
		List<Members> list = new ArrayList<>();
		try(var con = MyConnection.getConnection()) {
			String query = "SELECT * FROM members";
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while(rs.next()) {
				Members member = new Members();
				member.setCard_id(rs.getInt("card_id"));
				member.setName(rs.getString("name"));
				member.setRoll_no(rs.getInt("roll_no"));
				member.setClass_year(rs.getString("class_year"));
				member.setAcademic_year(rs.getString("academic_year"));
				member.setRegister_date(LocalDate.parse(rs.getString("register_date")));
				member.setExpried_date(LocalDate.parse(rs.getString("expried_date")));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean UpdateMembers(Members member) {
		try(var con = MyConnection.getConnection()) {
			String query = "UPDATE members SET name = ?, roll_no = ?, class_year = ?, academic_year = ?, register_date = ?, expried_date = ?"
							+ "WHERE card_id = ?";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, member.getName());
			pstm.setInt(2, member.getRoll_no());
			pstm.setString(3, member.getClass_year());
			pstm.setString(4, member.getAcademic_year());
			pstm.setDate(5, Date.valueOf(member.getRegister_date()));
			pstm.setDate(6, Date.valueOf(member.getExpried_date()));
			pstm.setInt(7, member.getCard_id());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<Members> searchMembers(String name, LocalDate expried) {
		List<Members> list = new ArrayList<>();
		try(var con = MyConnection.getConnection()) {
			String query ="""
					SELECT * FROM  members WHERE  name = ? AND expried_date = ?
					""";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setDate(2, Date.valueOf(expried));
			var rs = pstm.executeQuery();
			while(rs.next()) {
				Members member = new Members();
				member.setCard_id(rs.getInt("card_id"));
				member.setName(rs.getString("name"));
				member.setRoll_no(rs.getInt("roll_no"));
				member.setClass_year(rs.getString("class_year"));
				member.setAcademic_year(rs.getString("academic_year"));
				member.setRegister_date(LocalDate.parse(rs.getString("register_date")));
				member.setExpried_date(LocalDate.parse(rs.getString("expried_date")));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean saveMembers(Members member) {
		try(var con = MyConnection.getConnection()) {
			String query = "INSERT INTO members (card_id, name, roll_no, class_year, academic_year, register_date, expried_date)"
							+ "VALUES (?,?,?,?,?,?,?)";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, member.getCard_id());
			pstm.setString(2, member.getName());
			pstm.setInt(3, member.getRoll_no());
			pstm.setString(4, member.getClass_year());
			pstm.setString(5, member.getAcademic_year());
			pstm.setDate(6, Date.valueOf(member.getRegister_date()));
			pstm.setDate(7, Date.valueOf(member.getExpried_date()));
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<Books> searchBooks(String code, String author, String category, String avaliable) {
		List<Books> list = new ArrayList<>();
		try(var con = MyConnection.getConnection()) {
			String query = """
					SELECT b.code, b.title, b.avaliable, a.name 'author', c.name 'category' FROM 
					books b, authors a, categories c
					WHERE b.author_id = a.id AND
					b.category_id = c.id 
					""";
			List<Object> params = new ArrayList<>();
			if(!author.isEmpty()) {
				query += "AND a.name LIKE ?";
				params.add("%" + author + "%");
			}
			if(!category.isEmpty()) {
				query += "AND c.name LIKE ?";
				params.add("%" + category + "%");
			}
			if(!code.isEmpty()) {
				query += "AND b.code = ?";
				params.add( code );
			}
			if(!avaliable.isEmpty()) {
				query += "AND b.avaliable = ?";
				params.add(avaliable);
			}
			var pstm = con.prepareStatement(query);
			for(var i = 0; i < params.size();i++) {
				pstm.setObject((i+1), params.get(i));
			}
			var rs = pstm.executeQuery();
			while(rs.next()) {
				Books book = new Books();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setAvaliable(rs.getInt("avaliable"));
				
				Authors auth = new Authors();
				auth.setName(rs.getString("author"));
				book.setAuthor(auth);
				
				Categories cate = new Categories();
				cate.setName(rs.getString("category"));
				book.setCategory(cate);
				
				list.add(book);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Books> findAllBooks() {
		List<Books> list = new ArrayList<>();
		try(var con = MyConnection.getConnection()) {
			String query = """
					SELECT b.code, b.title, b.avaliable, a.name 'author', c.name 'category' FROM 
					books b, authors a, categories c
					WHERE b.author_id = a.id AND
					b.category_id = c.id 
					""";
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while(rs.next()) {
				Books b = new Books();
				b.setCode(rs.getInt("code"));
				b.setTitle(rs.getString("name"));
				b.setAvaliable(rs.getInt("avaliable"));
				
				Authors a = new Authors();
				a.setName(rs.getString("name"));
				b.setAuthor(a);
				
				Categories c = new Categories();
				c.setName(rs.getString("name"));
				b.setCategory(c);
				list.add(b);
			}
		} catch (Exception e) {
			
		}
		return list;
	}

	public static void deleteBookByCode(int code) {
		try(var con = MyConnection.getConnection()) {
			String query = "DELETE FROM books WHERE code = ?";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, code);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static Librarians login(String email, String password) {
		Librarians user = null;
		try(var con = MyConnection.getConnection())  {
			var query = "SELECT * FROM librarian WHERE name = ? AND password = ?";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, email);
			pstm.setString(2, password);
			
			var rs = pstm.executeQuery();
			if(rs.next()) {
				user = new Librarians();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				
				//user.setLib_name(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public static Borrows borrowBook(String member_id, String book_id) {
		Borrows borr = null;
		try(var con = MyConnection.getConnection()) {
//			INSERT INTO borrows (id,card_id, book_id, borrow_date,due_date,return_date fees, created_by)
//			VALUES (?,?,?,?,?,?,?,?) 
			String query = """
					SELECT  m.card_id,m.expired_date,k.code, k.avaliable   FROM 
						members m, books k
						WHERE m.card_id = ? AND
						k.code = ?
					
					""";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, Integer.parseInt(member_id));
			pstm.setInt(2, Integer.parseInt(book_id));
			
			var rs = pstm.executeQuery();
			while(rs.next()){
				Members mem = new Members();
				mem.setCard_id(rs.getInt("card_id"));
				mem.setExpried_date(LocalDate.parse(rs.getString("expried_date")));
				
				Books b = new Books();
				b.setCode(rs.getInt("code"));
				b.setAvaliable(rs.getInt("avaliable"));
				
				
				borr = new Borrows();
				borr.setMember(mem);
				borr.setBook(b);
				
//				borr = new Borrows();
//				borr.setId(rs.getInt("id"));
//				borr.getMember().setCard_id(rs.getInt("card_id"));
//				borr.getBook().setCode(rs.getInt("code"));
//				borr.setBorrow_date(LocalDate.parse(rs.getString("borrow_date")));
//				borr.setDue_date(LocalDate.parse(rs.getString("due_date")));
//				borr.setReturn_date(LocalDate.parse(rs.getString("return_date")));
//				borr.setFees(rs.getInt("fees"));
					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return borr;
		
	}

	public static void AddBorrowBook(Borrows borrow) {
		try(var con = MyConnection.getConnection()) {
			String query = "INSERT INTO borrows (id, card_id, book_id, borrow_date, due_date, return_date, fees, created_by)"
							+"VALUES(?,?,?,?,?,?,?,?)";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, borrow.getId());
			pstm.setInt(2, borrow.getMember().getCard_id());
			pstm.setInt(3, borrow.getBook().getCode());
			pstm.setDate(4, Date.valueOf(borrow.getBorrow_date()));
			pstm.setDate(5, Date.valueOf(borrow.getDue_date()));
			pstm.setDate(6, Date.valueOf(borrow.getReturn_date()));
			pstm.setInt(7, borrow.getFees());
			pstm.setString(8, borrow.getCreated_by().getName());
			pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static List<Borrows> findAllBorrows() {
		List<Borrows> list = new ArrayList<>();
		try(var con = MyConnection.getConnection()) {
			String query = """
						SELECT * FROM borrows , members, books 
						WHERE borrows.card_id = members.card_id
						AND borrows.book_id = books.code
					""";
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while(rs.next()) {
				Borrows b = new Borrows();
				b.setId(rs.getInt("id"));
				b.setBorrow_date(LocalDate.parse(rs.getString("borrow_date")));
				b.setDue_date(LocalDate.parse(rs.getString("due_date")));
				System.out.println("return-date: " + rs.getString("return_date"));
				LocalDate retun_date = (rs.getString("return_date") != null) ? LocalDate.parse(rs.getString("return_date")) : null;
				b.setReturn_date(retun_date);
				b.setFees(rs.getInt("fees"));
				
				
				Members m = new Members();
				m.setCard_id(rs.getInt("card_id"));
				b.setMember(m);
				
				Books book = new Books();
				book.setTitle(rs.getString("title"));
				b.setBook(book);
				
				Librarians l = new Librarians();
				l.setName(rs.getString("name"));
				b.setCreated_by(l);
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void saveLibrarian(String name, String city, LocalDate birthday) {
		try(var con = MyConnection.getConnection()) {
			String query = "INSERT INTO librarians (name , city, birthday) VALUES (?, ?, ?)";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setString(2, city);
			pstm.setDate(3, Date.valueOf(birthday));
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static List<Librarians> findAllLibrarians() {
		List<Librarians> list = new ArrayList<>();
		try(var con = MyConnection.getConnection()) {
			String query = "SELECT * FROM librarian";
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while(rs.next()) {
				Librarians libr = new Librarians();
				libr.setId(rs.getInt("id"));
				libr.setName(rs.getString("name"));
				libr.setCity(rs.getString("city"));
				libr.setBirthday(LocalDate.parse(rs.getString("birthday")));
				list.add(libr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void UpdateLibrary(Librarians library) {
		try(var con = MyConnection.getConnection()) {
			String query = "UPDATE librarians SET name = ? , city = ? , birthday = ? WHERE id = ?";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, library.getName());
			pstm.setString(2, library.getCity());
			pstm.setDate(3, Date.valueOf(library.getBirthday()));
			pstm.setInt(4, library.getId());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static List<Borrows> searchBorrowBook(String card_id) {
		List<Borrows> list = new ArrayList<>();
		try(var con = MyConnection.getConnection()) {
			String query ="""
						SELECT b.*, m.card_id,k.code   FROM 
						borrows b,members m, books k
						WHERE b.card_id = m.card_id AND
						b.book_id = k.code AND b.return_date is null
					"""; 
			List<Object> params = new ArrayList<>();
			if(!card_id.isEmpty()) {
				query += "AND m.card_id = ?";
				params.add(Integer.parseInt(card_id));
			}
			var pstm = con.prepareStatement(query);
			for(var i = 0; i < params.size();i++) {
				pstm.setObject((i+1), params.get(i));
			}
			var rs = pstm.executeQuery();
			while(rs.next()) {
				Borrows borr = new Borrows();
				borr.setId(rs.getInt("id"));
				borr.getMember().setCard_id(rs.getInt("card_id"));
				borr.getBook().setCode(rs.getInt("book_id"));
				borr.setBorrow_date(LocalDate.parse(rs.getString("borrow_date")));
				borr.setDue_date(LocalDate.parse(rs.getString("due_date")));
				LocalDate retun_date = (rs.getString("return_date") != null) ? LocalDate.parse(rs.getString("return_date")) : null;
				borr.setReturn_date(retun_date);
				borr.setFees(rs.getInt("fees"));
				list.add(borr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean returnBorrowBook(Borrows rebook) {
		try(var con = MyConnection.getConnection()) {
			String query = "UPDATE borrows  SET card_id = ?,book_id  = ?, borrow_date = ?, due_date =?, return_date = ? ,fees = ? WHERE id = ?";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, rebook.getCard_id());
			pstm.setInt(2, rebook.getBook_id());
			pstm.setDate(3, Date.valueOf(rebook.getBorrow_date()));
			pstm.setDate(4, Date.valueOf(rebook.getDue_date()));
			pstm.setDate(5, Date.valueOf(LocalDate.now()));
			pstm.setInt(6, rebook.getFees());
			pstm.setInt(7, rebook.getId());
			 //Duration day = Duration.between(LocalDate.now(), rebook.getDue_date());
			
			
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void borrowBooks(Borrows borrList) {
		try(var con = MyConnection.getConnection()) {
			String query = """
					INSERT INTO borrows (id,card_id, book_id, borrow_date,due_date,return_date fees, created_by)
					VALUES (?,?,?,?,?,?,?,?) 
					""";
				var pstm = con.prepareStatement(query);
				pstm.setInt(1, borrList.getId());
				pstm.setInt(2, borrList.getMember().getCard_id());
				pstm.setInt(3, borrList.getBook().getCode());
				pstm.setDate(4, Date.valueOf(borrList.getBorrow_date()));
				pstm.setDate(5, Date.valueOf(LocalDate.now().plusDays(7)));
				pstm.setDate(6, Date.valueOf(borrList.getReturn_date()));
				pstm.setInt(7, borrList.getFees());
				pstm.setInt(8 , borrList.getCreated_by().getId());
				pstm.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
	}

	public static boolean borrowBook(Borrows borr) {
		try(var con = MyConnection.getConnection()) {
			String query = """
					INSERT INTO borrows (id,card_id, book_id, borrow_date,due_date,return_date, fees, created_by)
					VALUES (?,?,?,?,?,?,?,?) 
					""";
				var pstm = con.prepareStatement(query);
				pstm.setInt(1, borr.getId());
				pstm.setInt(2, borr.getMember().getCard_id());
				pstm.setInt(3, borr.getBook().getCode());
				pstm.setDate(4, Date.valueOf(borr.getBorrow_date()));
				pstm.setDate(5, Date.valueOf(borr.getDue_date()));
				pstm.setDate(6, null);
				pstm.setInt(7, borr.getFees());
				pstm.setInt(8 , borr.getCreated_by().getId());
				pstm.executeUpdate();
				return true;
			}catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}

	public static Members findMemberCard(String member_id) {
		Members mem = null;
		try(var con = MyConnection.getConnection()) {
			String query = "SELECT  *   FROM members WHERE card_id = ? ";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, Integer.parseInt(member_id));
			
			
			var rs = pstm.executeQuery();
			while(rs.next()){
				mem = new Members();
				mem.setCard_id(rs.getInt("card_id"));
				mem.setExpried_date(LocalDate.parse(rs.getString("expried_date")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mem;
	}

	public static Books findBookCode(String book_id) {
		Books b = null;
		try(var con = MyConnection.getConnection()) {
			String query = "SELECT  *   FROM books WHERE code = ? ";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, Integer.parseInt(book_id));
			
			var rs = pstm.executeQuery();
			while(rs.next()){
				b = new Books();
				b.setCode(rs.getInt("code"));
				b.setTitle(rs.getString("title"));
				b.setAvaliable(rs.getInt("avaliable"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public static void borrowBooks(Members m, Books b) {
	
		try(var con = MyConnection.getConnection()) {
			String query = """
					INSERT INTO borrows (id,card_id, book_id, borrow_date,due_date,return_date, fees, created_by)
					VALUES (?,?,?,?,?,?,?,?) 
					""";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, 9);
			pstm.setInt(2, m.getCard_id());
			pstm.setInt(3, b.getCode());
			pstm.setDate(4, Date.valueOf(LocalDate.now()));
			pstm.setDate(5, Date.valueOf(LocalDate.now().plusDays(7)));
			pstm.setDate(6, null);
			pstm.setInt(7, 0);
			pstm.setString(8, null);
			pstm.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void UpdateAvaliable(Books b) {
		try(var con = MyConnection.getConnection()) {
			String query = 	"UPDATE books SET avaliable = ? WHERE code = ?";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, 1);
			pstm.setInt(2, b.getCode());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void borrowBookAvaliable(Borrows rebook) {
		try(var con = MyConnection.getConnection()) {
			String query = 	"UPDATE books SET avaliable = ? WHERE code = ?";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, 0);
			pstm.setInt(2, rebook.getBook_id());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void BookFees(Borrows rebook) {
		try(var con = MyConnection.getConnection()) {
			String query = 	"UPDATE borrows SET fees = ? WHERE id = ?";
			var pstm = con.prepareStatement(query);
			Period period = Period.between(rebook.getDue_date(), LocalDate.now());
    		long daysDiff = Math.abs(period.getDays());
			pstm.setLong(1, daysDiff * 100);
			pstm.setInt(2, rebook.getId());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
