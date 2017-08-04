insere(X, L, [X|L]).

insereFim(N, [], [N]).
insereFim(T, [H], L) :- insere(H, [T], L).
insereFim(N, [H|T], L) :- insereFim(N, T, X), insere(H, X, L).

getElem(0, [H|T], H).
getElem(N, [H|T], X) :- Z is N-1, getElem(Z, T, X).

:- initialization main.
main :-
	read_line_to_codes(user_input, A21),
	string_to_atom(A21,A11),
	atom_number(A11,N1),
	
	read_line_to_codes(user_input, A22),
	string_to_atom(A22,A12),
	atom_number(A12,N2),
	
	read_line_to_codes(user_input, A23),
	string_to_atom(A23,A13),
	atom_number(A13,N3),
	
	read_line_to_codes(user_input, A24),
	string_to_atom(A24,A14),
	atom_number(A14,N4),
	
	read_line_to_codes(user_input, P1),
	read_line_to_codes(user_input, P2),
	read_line_to_codes(user_input, P3),
	read_line_to_codes(user_input, P4),
	
	string_chars(P1, P11),
	getElem(N1, P11, C1),
	
	string_chars(P2, P12),
	getElem(N2, P12, C2),
	
	string_chars(P3, P13),
	getElem(N3, P13, C3),
	
	string_chars(P4, P14),
	getElem(N4, P14, C4),
	
	insereFim(C1, [], L1),
	insereFim(C2, L1, L2),
	insereFim(C3, L2, L3),
	insereFim(C4, L3, L4),
	
	string_chars(Final, L4),
	
	write(Final), nl.
