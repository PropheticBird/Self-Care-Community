DELIMITER $$

DROP PROCEDURE IF EXISTS sp_get_similar_problems$$

CREATE PROCEDURE sp_get_similar_problems (userLogin varchar(50)) 
BEGIN
	DECLARE userId INT;
	SELECT ID INTO userId FROM 
		(SELECT * FROM persons INNER JOIN person_credentials ON ID = Person_ID HAVING Login = userLogin) as tb1;

	CREATE TABLE tmpTagIds(tagId INT);
	INSERT INTO tmpTagIds SELECT DISTINCT (Tag_ID) FROM problem_to_tags WHERE Problem_ID IN
		(SELECT ID FROM problems WHERE Author_ID = userId);

	SELECT Problem_ID, COUNT(Problem_id) AS Tag_Count FROM problem_to_tags WHERE Tag_ID IN 
		(SELECT * FROM tmpTagIds) GROUP BY problem_id ORDER BY tag_count DESC;

	DROP TABLE tmpTagIds;
END $$

DELIMITER ;