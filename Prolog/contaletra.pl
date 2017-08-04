
contaLetra(_, [], 0) :- !. 
contaLetra([L], [L|F], Q) :- contaLetra([L], F, T), Q is 1 + T.
contaLetra([L], [L1|F], Q) :- contaLetra([L], F, Q).

:- initialization main.

main :-
	read_line_to_codes(user_input, L1),
	read_line_to_codes(user_input, F1),
	
	string_chars(L1, L),
	string_chars(F1, F),
	
	contaLetra(L, F, R), 
	
	write(R), nl.
