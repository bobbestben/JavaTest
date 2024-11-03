select players.Name, scores.Sport, scores.Score
from scores
left join players on scores.Player_no = players.Player_no;