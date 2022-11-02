-- PART 1
select * from songs where name = 'Austin';

select artist from songs where genre = 'Country';

select name from songs where genre = 'Hip Hop' and duration > 3.5;

select * from songs where name like 'H%';

select * from songs where genre = 'Country' and artist like '%Allen';


--PART 2
update songs set fav = true where genre = 'Hip Hop' ;

update songs set fav = true where artist = 'Nirvana';

update songs set fav = true where name = 'Austin'or name = 'Springsteen';


--PART 3
delete from songs where fav = false;

delete from songs where genre = 'Country';

delete from songs where duration > 3.5;

delete from songs where artist = 'Jason Derulo';

