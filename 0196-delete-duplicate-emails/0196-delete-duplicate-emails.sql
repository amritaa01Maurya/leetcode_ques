# Write your MySQL query statement below
# 3) now deleting all rows from person table whose id not in grouptable
delete
from Person
where id not in 
                (select min_id  # 2) now from table grouptable we are selecting all id
                from (  select min(id)  # 1)here we are grouping the person table by email and giving smallest id from (id`s grouped together) as grouptable 
                        as min_id 
                        from Person 
                        group by email
                    )                     as groupTable
                );
