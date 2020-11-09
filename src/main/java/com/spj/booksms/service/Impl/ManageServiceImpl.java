package com.spj.booksms.service.Impl;

import com.spj.booksms.dao.*;
import com.spj.booksms.model.*;
import com.spj.booksms.service.ManageService;
import com.spj.booksms.tools.AuthTools;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private OrderFormDao orderFormDao;

    @Autowired
    private CarouselDao carouselDao;

    @Autowired
    private HotrecommendDao hotrecommendDao;

    @Autowired
    private SolrClient solrClient;


    @Override
    public String getCurrentUserId() {

        String userid= (String) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        if(AuthTools.isNullOrSpace(userid)){
            return null;
        }
        else {
            return userid;
        }

    }

    @Override
    public String getCurrentUserRole() {
        String role=null;
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            role = authority.getAuthority();

        }

        if(AuthTools.isNullOrSpace(role)){
            return null;
        }
        else{
            return role;
        }

    }

    @Override
    public String getUserIdByUserInfo(Users users) {
        return this.usersDao.getUerIdByUserInfo(users.getUsername(), users.getUpwd());
    }

    @Override
    public List<Book> getBooksBySolrEngine(String keyWorld) {
        List<Book> books = new ArrayList<>();
        try {
            SolrQuery params =new SolrQuery("bname:" + keyWorld);
            QueryResponse response = solrClient.query(params);
            SolrDocumentList results = response.getResults();
            for (SolrDocument e : results) {
                Book book = new Book();
                Object bid = e.getFieldValue("bid");
                book.setBid(String.valueOf(bid).substring(1,bid.toString().length()-1));
                Object bname = e.getFieldValue("bname");
                book.setBname(String.valueOf(bname).substring(1,bname.toString().length()-1));
                Object bauthor = e.getFieldValue("bauthor");
                book.setBauthor(String.valueOf(bauthor).substring(1, bauthor.toString().length()-1));
                Object bversio = e.getFieldValue("bversion");
                book.setBversion(String.valueOf(bversio).substring(1, bversio.toString().length()-1));
                Object bimage = e.getFieldValue("bimage");
                book.setBimage(String.valueOf(bimage).substring(1, bimage.toString().length()-1));
                Object oldcost = e.getFieldValue("boldcost");
                book.setBoldcost( Short.valueOf(oldcost.toString().substring(1, oldcost.toString().length()-3)));

                Object newcost = e.getFieldValue("bnewcost");
                book.setBnewcost(Short.valueOf(newcost.toString().substring(1, oldcost.toString().length()-4)));
                Object bintro = e.getFieldValue("bintro");
                book.setBintro(String.valueOf(bintro));
                Object btype = e.getFieldValue("btype");
                book.setBtype(String.valueOf(btype).substring(1, btype.toString().length()-1));
                Object star = e.getFieldValue("bstar");
                book.setBstar(Short.valueOf(star.toString().substring(1, oldcost.toString().length()-5)));
                Object bstype = e.getFieldValue("bstype");
                book.setBstype(String.valueOf(bstype).substring(1, bstype.toString().length()-1));

                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public boolean update(Users users) {
        try {
            usersDao.save(users);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addBook(Book book) {
        try {
            Book save = bookDao.save(book);
            solrClient.addBean(save);
            solrClient.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBook(String id) {
        try {
            bookDao.delete(bookDao.getOne(id));
            solrClient.deleteById(id);
            solrClient.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBook(Book book) {
        try {
            bookDao.save(book);
            solrClient.deleteById(book.getBid());
            solrClient.addBean(book);
            solrClient.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Book queryBook(String id) {
        try {
            return bookDao.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> queryBookList() {
        try {
            return bookDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> queryBookListByType(String type) {
        try {
            return bookDao.getBooksByType(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Users queryUserByUsernameAndPassword(String username, String upassword) {
        try {
            return usersDao.findUserByUsernameAndPassword(username, upassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> queryBooksByBstype(String bsType) {
        try {
            return bookDao.getBooksByBstype(bsType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public List<Book> queryNovelList() {
//        try {
//            return bookDao.getnovelBooks();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public boolean addOrderForm(Orderform orderform) {
        try {
            orderFormDao.save(orderform);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteOrderForm(String id) {
        try {
            orderFormDao.delete(orderFormDao.getOne(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateOrderForm(Orderform orderform) {
        try {
            orderFormDao.save(orderform);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Orderform queryOrderForm(String id) {
        try {
            return orderFormDao.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Orderform> queryOrderFormList() {
        try {
            return orderFormDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




    @Override
    public boolean addCarousel(Carousel carousel) {
        try {
            carouselDao.save(carousel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCarousel(String id) {
        try {
            carouselDao.delete(carouselDao.getOne(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCarousel(Carousel carousel) {
        try {
            carouselDao.save(carousel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Carousel queryCarosuel(String id) {
        try {
            return carouselDao.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public boolean addHotrecommend(Hotrecommend hotrecommend) {
        try {
            hotrecommendDao.save(hotrecommend);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteHotrecommend(String id) {
        try {
            hotrecommendDao.delete(hotrecommendDao.getOne(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateHotrecommend(Hotrecommend hotrecommend) {
        try {
            hotrecommendDao.save(hotrecommend);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public Hotrecommend queryHotrecommend(String id) {
        try {
            return hotrecommendDao.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Carousel> queryCarouselList() {
        try {
            return carouselDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Hotrecommend> queryHotrecommendList() {
        try {
            return hotrecommendDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }





    @Autowired
    private ShoppingcartDao shoppingcartDao;
    @Override
    public boolean addShoppcart(Shoppingcart shoppingcart) {
        try {
             shoppingcartDao.save(shoppingcart);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteShopcart(String id) {
        try {
            shoppingcartDao.delete(shoppingcartDao.getOne(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateShopcart(Shoppingcart shoppingcart) {
        try {
            shoppingcartDao.save(shoppingcart);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Shoppingcart> queryShopcartList() {
        try {
            return shoppingcartDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Shoppingcart queryShopcart(String id) {
        try {
            return shoppingcartDao.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        try {
            usersDao.delete(usersDao.getOne(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Users queryUser(String id) {
        try {
            return usersDao.getOne(id);
        } catch (Exception e) {
            System.out.println("查询单个用户出错！！");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Users> queryUserList() {
        try {
            return usersDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addUser(Users users) {
        try {
            usersDao.save(users);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
