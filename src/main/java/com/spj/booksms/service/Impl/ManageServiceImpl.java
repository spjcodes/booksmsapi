package com.spj.booksms.service.Impl;

import com.spj.booksms.dao.*;
import com.spj.booksms.model.*;
import com.spj.booksms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            bookDao.save(book);
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
