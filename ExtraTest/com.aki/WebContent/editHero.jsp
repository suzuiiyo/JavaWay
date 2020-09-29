<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*, bean.*, java.sql.*"%>
<meta content="text/html; charset=utf-8">

<form action='updateHero' method='post'>
    名字: <input type='text' name='name' value='${hero.name}'> <br>
    血量: <input type='text' name='hp' value='${hero.hp}'><br>
    攻击: <input type='text' name='attack' value='${hero.attack}'><br>
    <input type='hidden' name='id' value='${hero.id}'>
    <input type='submit' value='更新'>
</form>