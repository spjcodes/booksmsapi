package com.spj.booksms.service;

import com.spj.booksms.model.*;

import java.util.List;

public interface ManageService {
    public boolean addUser(Users users);
    public boolean update(Users users);
    public boolean deleteUser(String id);
    public Users queryUser(String id);
    public List<Users> queryUserList();

    public boolean addBook(Book book);
    public boolean deleteBook(String id);
    public boolean updateBook(Book book);
    public Book queryBook(String id);
    public List<Book> queryBookList();
    public List<Book> queryBookListByType(String Type);
    public List<Book> queryBooksByBstype(String bsType);

    public boolean addOrderForm(Orderform orderform);
    public boolean deleteOrderForm(String id);
    public boolean updateOrderForm(Orderform orderform);
    public Orderform queryOrderForm(String id);
    public List<Orderform> queryOrderFormList();

    public boolean addCarousel(Carousel carousel);
    public boolean deleteCarousel(String id);
    public boolean updateCarousel(Carousel carousel);
    public Carousel queryCarosuel(String id);
    public List<Carousel> queryCarouselList();

    public boolean addHotrecommend(Hotrecommend hotrecommend);
    public boolean deleteHotrecommend(String id);
    public boolean updateHotrecommend(Hotrecommend hotrecommend);
    public  Hotrecommend queryHotrecommend(String id);
    public List<Hotrecommend> queryHotrecommendList();


}
