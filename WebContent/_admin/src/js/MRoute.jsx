/**
 * Created by a1 on 2016/5/5.
 */

import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, IndexRoute, hashHistory } from 'react-router';

import LoginPage         from './page/LoginPage';
import MainPage          from './page/MainPage';
import HomePage          from './page/HomePage';
import NotFoundPage      from './page/NotFoundPage';

import AddArticlePage    from './page/article/AddArticlePage';
import EditArticlePage   from './page/article/EditArticlePage';
import DelArticlePage    from './page/article/DelArticlePage';
import AddNotePage       from './page/note/AddNotePage';
import EditNotePage      from './page/note/EditNotePage';
import DelNotePage       from './page/note/DelNotePage';
import AddBookPage       from './page/book/AddBookPage';
import EditBookPage      from './page/book/EditBookPage';
import DelBookPage       from './page/book/DelBookPage';
import EditCommentPage   from './page/comment/EditCommentPage';
import DelCommentPage    from './page/comment/DelCommentPage';
import AddLinkPage       from './page/link/AddLinkPage';
import EditLinkPage      from './page/link/EditLinkPage';
import DelLinkPage       from './page/link/DelLinkPage';
import AddSortPage       from './page/sort/AddSortPage';
import EditSortPage      from './page/sort/EditSortPage';
import DelSortPage       from './page/sort/DelSortPage';
import ArticleRecomPage  from './page/recom/ArticleRecomPage';
import NoteRecomPage     from './page/recom/NoteRecomPage';
import BookRecomPage     from './page/recom/BookRecomPage';
import AddUserPage       from './page/user/AddUserPage';
import EditUserPage      from './page/user/EditUserPage';
import DelUserPage       from './page/user/DelUserPage';


export default class MRoute extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <Router history={hashHistory}>
                <Route name="登录页"                                                               path="/"                 component={LoginPage}/>
                <Route name="首页"                             bpath="#/home"                      path="/home"             component={MainPage}>
                    <IndexRoute name="首页"                    bpath="#/home"                                               component={HomePage}/>
                    <Route name="新增文章"   sort="Article"    bpath="#/home/addArticle"           path="addArticle"        component={AddArticlePage}/>
                    <Route name="编辑文章"   sort="Article"    bpath="#/home/editArticle/:id"      path="editArticle/:id"   component={EditArticlePage}/>
                    <Route name="删除文章"   sort="Article"    bpath="#/home/delArticle/:id"       path="delArticle/:id"    component={DelArticlePage}/>
                    <Route name="新增笔记"   sort="Note"       bpath="#/home/addNote"              path="addNote"           component={AddNotePage}/>
                    <Route name="编辑笔记"   sort="Note"       bpath="#/home/editNote/:id"         path="editNote/:id"      component={EditNotePage}/>
                    <Route name="删除笔记"   sort="Note"       bpath="#/home/delNote/:id"          path="delNote/:id"       component={DelNotePage}/>
                    <Route name="新增图书"   sort="Book"       bpath="#/home/addBook"              path="addBook"           component={AddBookPage}/>
                    <Route name="编辑图书"   sort="Book"       bpath="#/home/editBook/:id"         path="editBook/:id"      component={EditBookPage}/>
                    <Route name="删除图书"   sort="Book"       bpath="#/home/delBook/:id"          path="delBook/:id"       component={DelBookPage}/>
                    <Route name="编辑评论"   sort="Comment"    bpath="#/home/editComment/:id"      path="editComment/:id"   component={EditCommentPage}/>
                    <Route name="删除评论"   sort="Comment"    bpath="#/home/delComment/:id"       path="delComment/:id"    component={DelCommentPage}/>
                    <Route name="新增外链"   sort="Link"       bpath="#/home/addLink"              path="addLink"           component={AddLinkPage}/>
                    <Route name="编辑外链"   sort="Link"       bpath="#/home/editLink/:id"         path="editLink/:id"      component={EditLinkPage}/>
                    <Route name="删除外链"   sort="Link"       bpath="#/home/delLink/:id"          path="delLink/:id"       component={DelLinkPage}/>
                    <Route name="新增分类"   sort="Sort"       bpath="#/home/addSort"              path="addSort"           component={AddSortPage}/>
                    <Route name="编辑分类"   sort="Sort"       bpath="#/home/editSort/:id"         path="editSort/:id"      component={EditSortPage}/>
                    <Route name="删除分类"   sort="Sort"       bpath="#/home/delSort/:id"          path="delSort/:id"       component={DelSortPage}/>
                    <Route name="文章推荐量" sort="Recom"      bpath="#/home/articleRecom/:id"     path="articleRecom/:id"  component={ArticleRecomPage}/>
                    <Route name="笔记推荐量" sort="Recom"      bpath="#/home/noteRecom/:id"        path="noteRecom/:id"     component={NoteRecomPage}/>
                    <Route name="图书推荐量" sort="Recom"      bpath="#/home/bookRecom/:id"        path="bookRecom/:id"     component={BookRecomPage}/>
                    <Route name="新增用户"   sort="User"       bpath="#/home/addUser"              path="addUser"           component={AddUserPage}/>
                    <Route name="编辑用户"   sort="User"       bpath="#/home/editUser/:id"         path="editUser/:id"      component={EditUserPage}/>
                    <Route name="删除用户"   sort="User"       bpath="#/home/delUser/:id"          path="delUser/:id"       component={DelUserPage}/>
                </Route>
                <Route path="*" component={NotFoundPage}/>
            </Router>
        );
    }
};











