一般其他组件与ListView嵌合在一起滚动的方案有如下几种：

1.整个页面变为一个ListView，其他组件（如顶部）成为ListView的一个Item或者Header；

2.使用ScrollView嵌套ListView；


开发场景：

某一app在1.0版本ActivityA页面已经包裹了一些内容组件，之后到了2.0版本，需要在当前页面下加一个可以滑动的ListView。
这个时候当然首先想到的是，使用ScrollView嵌套ListView来实现。但在ScrollView嵌套ListView一般会有些问题出现，比如无法滑动、ListView只能显示一行等问题。
本案例将对在已有的页面中添加一个ListView进行分页加载的处理办法来进行阐述。

效果图如下：

http://img.blog.csdn.net/20170712141838461?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZ2Fuc2hlbm1s/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center
