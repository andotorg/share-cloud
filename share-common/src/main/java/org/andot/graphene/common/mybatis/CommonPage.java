package org.andot.graphene.common.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/***
 * MyBatis 数据集合进行分页返回分页信息
 * @author Andot
 * @param <T>
 * @since 1.0
 */
@Setter
@Getter
public class CommonPage<T> {
    /***
     * 页码
     */
    private Integer pageNum;
    /***
     * 行数
     */
    private Integer pageSize;
    /***
     * 总页数
     */
    private Integer totalPage;
    /***
     * 数据总数
     */
    private Long total;
    /***
     * 数据集合
     */
    private List<T> list;

    /***
     * 将MyBatis PageHelper 分页后的list转为分页信息
     * @param list
     * @param <T>
     * @return
     */
    public static <T> CommonPage<T> restPage(List<T> list){
        CommonPage<T> result = new CommonPage<>();
        PageInfo<T> pageInfo = new PageInfo<>();
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotalPage(pageInfo.getPages());
        result.setTotal(pageInfo.getTotal());
        result.setList(list);
        return result;
    }


    /***
     * 将MyBatis PageHelper 把分页转为分页信息
     * @param pageInfo
     * @param <T>
     * @return
     */
    public static <T> CommonPage<T> restPage(Page<T> pageInfo){
        CommonPage<T> result = new CommonPage<>();
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotalPage(pageInfo.getPages());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getResult());
        return result;
    }
}
