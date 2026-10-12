# StudentManagementSystem

Java 面向对象版本 · 学生管理系统 · 控制台实现增删查改

## ✨ 项目介绍

基于 Java 面向对象思想开发。用 `abstract class Person` 抽象出姓名、性别、年龄等共同属性，
由 `Student` 继承并补充学号、成绩。`Student` 实现 `Comparable<Student>` 接口，
按学号定义排序规则，使数组可直接交给 `Arrays.sort` 处理。
`ArrayUtils` 封装数组查找逻辑，`StudentView` 负责控制台菜单交互，`Test` 为程序入口。

## 📂 文件结构

```
src/Demo/
├─ Person.java          抽象父类，封装 name/sex/age，abstract display()
├─ Student.java         继承 Person，补充 sid/score，实现 display() 与 compareTo()
├─ ArrayUtils.java      工具类，静态方法按学号查找索引
├─ StudentView.java     控制台菜单与增删改查逻辑
└─ Test.java            程序入口 main 方法
```

## 💻 开发环境

- JDK 8 及以上
- IDEA

## 📌 功能清单

- 添加学生信息（**学号重复会被拦截**）
- 按学号修改学生信息
- 按学号删除学生信息
- 查看全部学生信息（按学号升序排列）

## 📝 版本记录

| 版本 | 内容 |
|---|---|
| **v2.0** | 修复学号重复添加问题；手写冒泡排序改为 `Arrays.sort` + 实现 `Comparable` |
| v1.5 | 新增 `Person` 抽象类，`Student` 继承并用抽象方法 + 多态实现信息展示；完成 CRUD 基础功能 |
| v1.0 | 面向对象版本基础增删查 |

## ⚠️ 已知待改进

- 数组容量固定为 50，超出后会数组越界（可改用 `ArrayList` 解决）
- 暂无独立「按学号查找」功能（菜单中未提供，只能查看全部）
- 数据仅存于内存，程序退出即丢失，尚未接入数据库
