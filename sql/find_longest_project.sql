SELECT NAME, DATEDIFF(MONTH, START_DATE, FINISH_DATE) MONTH_COUNT
FROM PROJECT
WHERE DATEDIFF(MONTH, START_DATE, FINISH_DATE) IN
      (
          SELECT DATEDIFF(MONTH, START_DATE, FINISH_DATE) mc
          FROM PROJECT
          ORDER BY mc DESC
          LIMIT 1
      );
