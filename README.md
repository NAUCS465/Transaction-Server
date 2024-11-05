# Transaction-Server
A transaction server using OCC for our CS465 class


Compile from main folder with this:

```javac -d build -sourcepath src src/transaction/client/*.java src/transaction/comm/*.java src/transaction/server/account/*.java src/transaction/server/transaction/*.java src/transaction/server/*.java src/utils/*.java```

# Run Server

from main folder:

```java -cp build transaction.server.TransactionServer config/TransactionServer.properties```

# Run Client

from main folder:

```java -cp build transaction.client.TransactionClient config/TransactionClient.properties config/TransactionServer.properties```

# Server Output
```
PS D:\Transaction-Server> java -cp build transaction.server.TransactionServer config/TransactionServer.properties
[TransactionServer.TransactionServer] TransactionManager created
[TransactionServer.TransactionServer] AccountManager created
[TransactionServer.TransactionServer] ServerSocket created

8 [TransactionManagerWorker.run] OPEN_TRANSACTION #3
27 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #9
54 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, balance $10
143 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #9, balance to write $7
149 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, wrote $7
163 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #0
165 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #0, balance $10
176 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #0, balance to write $13
179 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #0, wrote $13
189 [TransactionManager.validateTransaction] Transaction #3 successfully validated
190 [TransactionManager.writeTransaction] Transaction #3 wrote balance $13 to account #0
191 [TransactionManager.writeTransaction] Transaction #3 wrote balance $7 to account #9
192 [TransactionManagerWorker.run] CLOSE_TRANSACTION #3 - COMMITTED

20 [TransactionManagerWorker.run] OPEN_TRANSACTION #13
25 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #3
51 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, balance $10
140 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #3, balance to write $9
146 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, wrote $9
172 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
174 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $10
180 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $11
181 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $11
185 [TransactionManager.validateTransaction] Transaction #13 successfully validated
186 [TransactionManager.writeTransaction] Transaction #13 wrote balance $9 to account #3
187 [TransactionManager.writeTransaction] Transaction #13 wrote balance $11 to account #8
188 [TransactionManagerWorker.run] CLOSE_TRANSACTION #13 - COMMITTED

15 [TransactionManagerWorker.run] OPEN_TRANSACTION #15
40 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #4
41 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #4, balance $10
62 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #4, balance to write $5
69 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #4, wrote $5
70 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #1
74 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, balance $10
80 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #1, balance to write $15
82 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, wrote $15
133 [TransactionManager.validateTransaction] Transaction #15 successfully validated
182 [TransactionManager.writeTransaction] Transaction #15 wrote balance $15 to account #1
183 [TransactionManager.writeTransaction] Transaction #15 wrote balance $5 to account #4
184 [TransactionManagerWorker.run] CLOSE_TRANSACTION #15 - COMMITTED

12 [TransactionManagerWorker.run] OPEN_TRANSACTION #19
26 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #5
47 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, balance $10
130 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #5, balance to write $5
132 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, wrote $5
159 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #3
161 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, balance $10
175 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #3, balance to write $15
178 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, wrote $15
193 [TransactionManager.validateTransaction] Conflict detected with Transaction #13
194 [TransactionManagerWorker.run] CLOSE_TRANSACTION #19 - ABORTED

3 [TransactionManagerWorker.run] OPEN_TRANSACTION #5
22 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #5
56 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, balance $10
112 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #5, balance to write $3
119 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, wrote $3
158 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #6
160 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, balance $10
173 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #6, balance to write $17
177 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, wrote $17
195 [TransactionManager.validateTransaction] Transaction #5 successfully validated
196 [TransactionManager.writeTransaction] Transaction #5 wrote balance $3 to account #5
197 [TransactionManager.writeTransaction] Transaction #5 wrote balance $17 to account #6
198 [TransactionManagerWorker.run] CLOSE_TRANSACTION #5 - COMMITTED

5 [TransactionManagerWorker.run] OPEN_TRANSACTION #9
32 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #4
59 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #4, balance $10
96 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #4, balance to write $5
99 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #4, wrote $5
135 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
137 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $10
169 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $15
170 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $15
199 [TransactionManager.validateTransaction] Conflict detected with Transaction #15
200 [TransactionManagerWorker.run] CLOSE_TRANSACTION #9 - ABORTED

17 [TransactionManagerWorker.run] OPEN_TRANSACTION #14
21 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #6
45 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, balance $10
88 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #6, balance to write $5
90 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, wrote $5
120 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #5
123 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, balance $10
164 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #5, balance to write $15
166 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, wrote $15
201 [TransactionManager.validateTransaction] Conflict detected with Transaction #5
202 [TransactionManagerWorker.run] CLOSE_TRANSACTION #14 - ABORTED

16 [TransactionManagerWorker.run] OPEN_TRANSACTION #8
34 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
42 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $10
104 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $5
111 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $5
152 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #2
156 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, balance $10
168 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #2, balance to write $15
171 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, wrote $15
203 [TransactionManager.validateTransaction] Conflict detected with Transaction #13
204 [TransactionManagerWorker.run] CLOSE_TRANSACTION #8 - ABORTED

7 [TransactionManagerWorker.run] OPEN_TRANSACTION #7
23 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #3
58 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, balance $10
97 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #3, balance to write $5
100 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, wrote $5
136 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
138 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $10
162 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $15
167 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $15
205 [TransactionManager.validateTransaction] Conflict detected with Transaction #13
206 [TransactionManagerWorker.run] CLOSE_TRANSACTION #7 - ABORTED

19 [TransactionManagerWorker.run] OPEN_TRANSACTION #1
37 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #3
48 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, balance $10
76 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #3, balance to write $1
78 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, wrote $1
93 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #6
102 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, balance $10
134 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #6, balance to write $19
139 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, wrote $19
207 [TransactionManager.validateTransaction] Conflict detected with Transaction #13
208 [TransactionManagerWorker.run] CLOSE_TRANSACTION #1 - ABORTED

4 [TransactionManagerWorker.run] OPEN_TRANSACTION #6
24 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
44 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $10
117 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $1
122 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $1
142 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #6
144 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, balance $10
153 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #6, balance to write $19
155 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, wrote $19
209 [TransactionManager.validateTransaction] Conflict detected with Transaction #13
210 [TransactionManagerWorker.run] CLOSE_TRANSACTION #6 - ABORTED

2 [TransactionManagerWorker.run] OPEN_TRANSACTION #11
28 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #5
52 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, balance $10
92 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #5, balance to write $9
95 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, wrote $9
110 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #5
115 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, balance $9
148 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #5, balance to write $10
151 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, wrote $10
211 [TransactionManager.validateTransaction] Conflict detected with Transaction #5
212 [TransactionManagerWorker.run] CLOSE_TRANSACTION #11 - ABORTED

9 [TransactionManagerWorker.run] OPEN_TRANSACTION #12
39 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #9
55 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, balance $10
63 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #9, balance to write $5
81 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, wrote $5
84 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #2
86 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, balance $10
105 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #2, balance to write $15
109 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, wrote $15
213 [TransactionManager.validateTransaction] Conflict detected with Transaction #3
214 [TransactionManagerWorker.run] CLOSE_TRANSACTION #12 - ABORTED

13 [TransactionManagerWorker.run] OPEN_TRANSACTION #20
35 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #7
50 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #7, balance $10
121 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #7, balance to write $9
124 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #7, wrote $9
141 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #6
145 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, balance $10
154 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #6, balance to write $11
157 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, wrote $11
215 [TransactionManager.validateTransaction] Conflict detected with Transaction #5
216 [TransactionManagerWorker.run] CLOSE_TRANSACTION #20 - ABORTED

6 [TransactionManagerWorker.run] OPEN_TRANSACTION #18
36 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #2
49 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, balance $10
114 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #2, balance to write $1
118 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, wrote $1
126 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #1
128 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, balance $10
147 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #1, balance to write $19
150 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, wrote $19
217 [TransactionManager.validateTransaction] Conflict detected with Transaction #15
218 [TransactionManagerWorker.run] CLOSE_TRANSACTION #18 - ABORTED

10 [TransactionManagerWorker.run] OPEN_TRANSACTION #17
38 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #1
46 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, balance $10
72 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #1, balance to write $6
75 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, wrote $6
87 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #1
89 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, balance $6
103 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #1, balance to write $10
107 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, wrote $10
219 [TransactionManager.validateTransaction] Conflict detected with Transaction #15
220 [TransactionManagerWorker.run] CLOSE_TRANSACTION #17 - ABORTED

11 [TransactionManagerWorker.run] OPEN_TRANSACTION #16
33 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #9
43 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, balance $10
65 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #9, balance to write $7
68 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, wrote $7
83 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #0
85 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #0, balance $10
91 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #0, balance to write $13
94 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #0, wrote $13
221 [TransactionManager.validateTransaction] Conflict detected with Transaction #3
222 [TransactionManagerWorker.run] CLOSE_TRANSACTION #16 - ABORTED

1 [TransactionManagerWorker.run] OPEN_TRANSACTION #4
29 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #4
53 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #4, balance $10
113 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #4, balance to write $6
116 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #4, wrote $6
125 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #1
127 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, balance $10
129 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #1, balance to write $14
131 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, wrote $14
223 [TransactionManager.validateTransaction] Conflict detected with Transaction #15
224 [TransactionManagerWorker.run] CLOSE_TRANSACTION #4 - ABORTED

18 [TransactionManagerWorker.run] OPEN_TRANSACTION #2
30 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #4
57 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #4, balance $10
64 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #4, balance to write $5
67 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #4, wrote $5
77 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #0
79 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #0, balance $10
106 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #0, balance to write $15
108 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #0, wrote $15
225 [TransactionManager.validateTransaction] Conflict detected with Transaction #15
226 [TransactionManagerWorker.run] CLOSE_TRANSACTION #2 - ABORTED

14 [TransactionManagerWorker.run] OPEN_TRANSACTION #10
31 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #9
60 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, balance $10
61 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #9, balance to write $7
66 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, wrote $7
71 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
73 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $10
98 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $13
101 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $13
227 [TransactionManager.validateTransaction] Conflict detected with Transaction #13
228 [TransactionManagerWorker.run] CLOSE_TRANSACTION #10 - ABORTED

229 [TransactionManagerWorker.run] OPEN_TRANSACTION #21
235 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #4
236 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #4, balance $5
238 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #4, balance to write $0
240 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #4, wrote $0
244 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
246 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $11
250 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $16
252 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $16
268 [TransactionManager.validateTransaction] Transaction #21 successfully validated
269 [TransactionManager.writeTransaction] Transaction #21 wrote balance $0 to account #4
270 [TransactionManager.writeTransaction] Transaction #21 wrote balance $16 to account #8
274 [TransactionManagerWorker.run] CLOSE_TRANSACTION #21 - COMMITTED

234 [TransactionManagerWorker.run] OPEN_TRANSACTION #24
237 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #3
239 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, balance $9
242 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #3, balance to write $0
243 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, wrote $0
248 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #6
251 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, balance $17
254 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #6, balance to write $26
258 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, wrote $26
275 [TransactionManager.validateTransaction] Transaction #24 successfully validated
277 [TransactionManager.writeTransaction] Transaction #24 wrote balance $0 to account #3
278 [TransactionManager.writeTransaction] Transaction #24 wrote balance $26 to account #6
279 [TransactionManagerWorker.run] CLOSE_TRANSACTION #24 - COMMITTED

231 [TransactionManagerWorker.run] OPEN_TRANSACTION #23
249 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
253 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $11
256 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $2
259 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $2
260 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #6
262 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, balance $17
264 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #6, balance to write $26
266 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, wrote $26
280 [TransactionManager.validateTransaction] Conflict detected with Transaction #21
281 [TransactionManagerWorker.run] CLOSE_TRANSACTION #23 - ABORTED

435 [TransactionManagerWorker.run] OPEN_TRANSACTION #33
436 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #9
437 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, balance $7
438 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #9, balance to write $2
439 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, wrote $2
441 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #2
442 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, balance $6
444 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #2, balance to write $11
445 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, wrote $11
452 [TransactionManager.validateTransaction] Conflict detected with Transaction #37
453 [TransactionManagerWorker.run] CLOSE_TRANSACTION #33 - ABORTED

230 [TransactionManagerWorker.run] OPEN_TRANSACTION #22
255 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
257 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $11
261 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $6
263 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $6
265 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #2
267 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, balance $10
272 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #2, balance to write $15
276 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, wrote $15
282 [TransactionManager.validateTransaction] Conflict detected with Transaction #21
283 [TransactionManagerWorker.run] CLOSE_TRANSACTION #22 - ABORTED

233 [TransactionManagerWorker.run] OPEN_TRANSACTION #25
245 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #3
247 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, balance $9
271 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #3, balance to write $4
273 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, wrote $4
284 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
286 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $16
290 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $21
292 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $21
299 [TransactionManager.validateTransaction] Conflict detected with Transaction #21
302 [TransactionManagerWorker.run] CLOSE_TRANSACTION #25 - ABORTED

241 [TransactionManagerWorker.run] OPEN_TRANSACTION #27
288 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #5
289 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, balance $3
293 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #5, balance to write $2
295 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, wrote $2
296 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #5
297 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, balance $2
301 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #5, balance to write $3
303 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, wrote $3
306 [TransactionManager.validateTransaction] Transaction #27 successfully validated
307 [TransactionManager.writeTransaction] Transaction #27 wrote balance $3 to account #5
308 [TransactionManagerWorker.run] CLOSE_TRANSACTION #27 - COMMITTED

471 [TransactionManagerWorker.run] OPEN_TRANSACTION #41
472 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #6
473 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, balance $27
474 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #6, balance to write $22
475 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, wrote $22
476 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #5
477 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, balance $-2
478 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #5, balance to write $3
479 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, wrote $3
481 [TransactionManager.validateTransaction] Transaction #41 successfully validated
482 [TransactionManager.writeTransaction] Transaction #41 wrote balance $3 to account #5
483 [TransactionManager.writeTransaction] Transaction #41 wrote balance $22 to account #6
484 [TransactionManagerWorker.run] CLOSE_TRANSACTION #41 - COMMITTED

480 [TransactionManagerWorker.run] OPEN_TRANSACTION #43
486 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
487 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $14
488 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $5
489 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $5
491 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #6
493 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, balance $22
494 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #6, balance to write $31
495 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, wrote $31
497 [TransactionManager.validateTransaction] Conflict detected with Transaction #41
499 [TransactionManagerWorker.run] CLOSE_TRANSACTION #43 - ABORTED

485 [TransactionManagerWorker.run] OPEN_TRANSACTION #42
490 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #3
492 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, balance $5
496 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #3, balance to write $0
498 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, wrote $0
500 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
501 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $14
503 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $19
504 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $19
505 [TransactionManager.validateTransaction] Transaction #42 successfully validated
506 [TransactionManager.writeTransaction] Transaction #42 wrote balance $0 to account #3
507 [TransactionManager.writeTransaction] Transaction #42 wrote balance $19 to account #8
508 [TransactionManagerWorker.run] CLOSE_TRANSACTION #42 - COMMITTED

502 [TransactionManagerWorker.run] OPEN_TRANSACTION #44
509 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #9
510 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, balance $1
511 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #9, balance to write $-4
512 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, wrote $-4
513 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #2
514 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, balance $6
515 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #2, balance to write $11
516 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, wrote $11
517 [TransactionManager.validateTransaction] Transaction #44 successfully validated
518 [TransactionManager.writeTransaction] Transaction #44 wrote balance $11 to account #2
519 [TransactionManager.writeTransaction] Transaction #44 wrote balance $-4 to account #9
520 [TransactionManagerWorker.run] CLOSE_TRANSACTION #44 - COMMITTED

521 [TransactionManagerWorker.run] OPEN_TRANSACTION #45
522 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
523 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $19
524 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $10
525 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $10
526 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #6
527 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, balance $22
528 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #6, balance to write $31
529 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, wrote $31
530 [TransactionManager.validateTransaction] Transaction #45 successfully validated
531 [TransactionManager.writeTransaction] Transaction #45 wrote balance $31 to account #6
532 [TransactionManager.writeTransaction] Transaction #45 wrote balance $10 to account #8
533 [TransactionManagerWorker.run] CLOSE_TRANSACTION #45 - COMMITTED

232 [TransactionManagerWorker.run] OPEN_TRANSACTION #26
285 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #6
287 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, balance $26
291 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #6, balance to write $21
294 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, wrote $21
298 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #5
300 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, balance $3
304 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #5, balance to write $8
305 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, wrote $8
309 [TransactionManager.validateTransaction] Conflict detected with Transaction #24
310 [TransactionManagerWorker.run] CLOSE_TRANSACTION #26 - ABORTED

311 [TransactionManagerWorker.run] OPEN_TRANSACTION #28
312 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #2
313 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, balance $10
314 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #2, balance to write $1
315 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, wrote $1
316 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #1
317 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, balance $15
318 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #1, balance to write $24
319 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, wrote $24
320 [TransactionManager.validateTransaction] Transaction #28 successfully validated
321 [TransactionManager.writeTransaction] Transaction #28 wrote balance $24 to account #1
322 [TransactionManager.writeTransaction] Transaction #28 wrote balance $1 to account #2
323 [TransactionManagerWorker.run] CLOSE_TRANSACTION #28 - COMMITTED

324 [TransactionManagerWorker.run] OPEN_TRANSACTION #30
326 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #1
327 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, balance $24
329 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #1, balance to write $20
331 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, wrote $20
332 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #1
333 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, balance $20
335 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #1, balance to write $24
337 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, wrote $24
339 [TransactionManager.validateTransaction] Transaction #30 successfully validated
340 [TransactionManager.writeTransaction] Transaction #30 wrote balance $24 to account #1
342 [TransactionManagerWorker.run] CLOSE_TRANSACTION #30 - COMMITTED

325 [TransactionManagerWorker.run] OPEN_TRANSACTION #29
328 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #5
330 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, balance $3
334 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #5, balance to write $-2
336 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, wrote $-2
338 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #3
341 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, balance $0
343 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #3, balance to write $5
344 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, wrote $5
346 [TransactionManager.validateTransaction] Transaction #29 successfully validated
347 [TransactionManager.writeTransaction] Transaction #29 wrote balance $5 to account #3
348 [TransactionManager.writeTransaction] Transaction #29 wrote balance $-2 to account #5
349 [TransactionManagerWorker.run] CLOSE_TRANSACTION #29 - COMMITTED

345 [TransactionManagerWorker.run] OPEN_TRANSACTION #31
350 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #4
351 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #4, balance $0
352 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #4, balance to write $-4
353 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #4, wrote $-4
354 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #1
355 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, balance $24
356 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #1, balance to write $28
357 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #1, wrote $28
358 [TransactionManager.validateTransaction] Transaction #31 successfully validated
359 [TransactionManager.writeTransaction] Transaction #31 wrote balance $28 to account #1
360 [TransactionManager.writeTransaction] Transaction #31 wrote balance $-4 to account #4
361 [TransactionManagerWorker.run] CLOSE_TRANSACTION #31 - COMMITTED

362 [TransactionManagerWorker.run] OPEN_TRANSACTION #32
363 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #4
365 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #4, balance $-4
366 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #4, balance to write $-9
367 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #4, wrote $-9
368 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #0
369 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #0, balance $13
372 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #0, balance to write $18
373 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #0, wrote $18
377 [TransactionManager.validateTransaction] Transaction #32 successfully validated
378 [TransactionManager.writeTransaction] Transaction #32 wrote balance $18 to account #0
379 [TransactionManager.writeTransaction] Transaction #32 wrote balance $-9 to account #4
380 [TransactionManagerWorker.run] CLOSE_TRANSACTION #32 - COMMITTED

364 [TransactionManagerWorker.run] OPEN_TRANSACTION #34
370 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #7
371 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #7, balance $10
374 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #7, balance to write $9
376 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #7, wrote $9
382 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #6
383 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, balance $26
384 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #6, balance to write $27
385 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, wrote $27
388 [TransactionManager.validateTransaction] Transaction #34 successfully validated
389 [TransactionManager.writeTransaction] Transaction #34 wrote balance $27 to account #6
390 [TransactionManager.writeTransaction] Transaction #34 wrote balance $9 to account #7
392 [TransactionManagerWorker.run] CLOSE_TRANSACTION #34 - COMMITTED

386 [TransactionManagerWorker.run] OPEN_TRANSACTION #37
398 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
400 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $16
402 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $11
403 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $11
404 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #2
405 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, balance $1
406 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #2, balance to write $6
407 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #2, wrote $6
408 [TransactionManager.validateTransaction] Transaction #37 successfully validated
409 [TransactionManager.writeTransaction] Transaction #37 wrote balance $6 to account #2
410 [TransactionManager.writeTransaction] Transaction #37 wrote balance $11 to account #8
411 [TransactionManagerWorker.run] CLOSE_TRANSACTION #37 - COMMITTED

375 [TransactionManagerWorker.run] OPEN_TRANSACTION #35
387 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #3
391 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, balance $5
394 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #3, balance to write $0
395 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #3, wrote $0
399 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
401 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $16
413 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $21
415 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $21
419 [TransactionManager.validateTransaction] Conflict detected with Transaction #37
421 [TransactionManagerWorker.run] CLOSE_TRANSACTION #35 - ABORTED

381 [TransactionManagerWorker.run] OPEN_TRANSACTION #36
396 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #6
397 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, balance $27
412 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #6, balance to write $22
414 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, wrote $22
418 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #5
420 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, balance $-2
422 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #5, balance to write $3
424 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #5, wrote $3
427 [TransactionManager.validateTransaction] Conflict detected with Transaction #34
428 [TransactionManagerWorker.run] CLOSE_TRANSACTION #36 - ABORTED

393 [TransactionManagerWorker.run] OPEN_TRANSACTION #38
416 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
417 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $11
423 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $2
425 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $2
426 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #6
429 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, balance $27
430 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #6, balance to write $36
431 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #6, wrote $36
432 [TransactionManager.validateTransaction] Conflict detected with Transaction #34
433 [TransactionManagerWorker.run] CLOSE_TRANSACTION #38 - ABORTED

434 [TransactionManagerWorker.run] OPEN_TRANSACTION #39
440 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #9
443 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, balance $7
446 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #9, balance to write $4
447 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, wrote $4
448 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #0
449 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #0, balance $18
450 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #0, balance to write $21
451 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #0, wrote $21
454 [TransactionManager.validateTransaction] Transaction #39 successfully validated
455 [TransactionManager.writeTransaction] Transaction #39 wrote balance $21 to account #0
456 [TransactionManager.writeTransaction] Transaction #39 wrote balance $4 to account #9
457 [TransactionManagerWorker.run] CLOSE_TRANSACTION #39 - COMMITTED

458 [TransactionManagerWorker.run] OPEN_TRANSACTION #40
459 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #9
460 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, balance $4
461 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #9, balance to write $1
462 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #9, wrote $1
463 [TransactionManagerWorker.run] READ_REQUEST >>>>>>>>>>>>>>>>>>>> account #8
464 [TransactionManagerWorker.run] READ_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, balance $11
465 [TransactionManagerWorker.run] WRITE_REQUEST >>>>>>>>>>>>>>>>>>> account #8, balance to write $14
466 [TransactionManagerWorker.run] WRITE_REQUEST <<<<<<<<<<<<<<<<<<<< account #8, wrote $14
467 [TransactionManager.validateTransaction] Transaction #40 successfully validated
468 [TransactionManager.writeTransaction] Transaction #40 wrote balance $14 to account #8
469 [TransactionManager.writeTransaction] Transaction #40 wrote balance $1 to account #9
470 [TransactionManagerWorker.run] CLOSE_TRANSACTION #40 - COMMITTED
[TransactionServer.run] Socket closed, shutting down ...


======================================= BRANCH TOTAL =======================================
0:21$ 1:28$ 2:11$ 3:0$ 4:-9$ 5:3$ 6:31$ 7:9$ 8:10$ 9:-4$ ---> $100
```

# Client Output
```
PS D:\Transaction-Server> java -cp build transaction.client.TransactionClient config/TransactionClient.properties config/TransactionServer.properties
Properties Summary
        HOST:               127.0.0.1
        PORT:               23656
        NUMBER_ACCOUNTS:    10
        NUMBER_TRANSACTIONS:20
Transaction #14 started, transfer $5: 6->5
Transaction #5 started, transfer $7: 5->6
Transaction #6 started, transfer $9: 8->6
Transaction #7 started, transfer $5: 3->8
Transaction #13 started, transfer $1: 3->8
Transaction #19 started, transfer $5: 5->3
Transaction #3 started, transfer $3: 9->0
Transaction #11 started, transfer $1: 5->5
Transaction #4 started, transfer $4: 4->1
Transaction #2 started, transfer $5: 4->0
Transaction #10 started, transfer $3: 9->8
Transaction #9 started, transfer $5: 4->8
Transaction #16 started, transfer $3: 9->0
Transaction #8 started, transfer $5: 8->2
Transaction #20 started, transfer $1: 7->6
Transaction #18 started, transfer $9: 2->1
Transaction #1 started, transfer $9: 3->6
Transaction #17 started, transfer $4: 1->1
Transaction #12 started, transfer $5: 9->2
Transaction #15 started, transfer $5: 4->1
Transaction #3 COMMITTED
        Transaction #9 ABORTED
Transaction #5 COMMITTED
Transaction #15 COMMITTED
        Transaction #8 ABORTED
Transaction #13 COMMITTED
        Transaction #19 ABORTED
        Transaction #7 ABORTED
        Transaction #1 ABORTED
        Transaction #14 ABORTED
        Transaction #6 ABORTED
        Transaction #11 ABORTED
        Transaction #12 ABORTED
        Transaction #20 ABORTED
        Transaction #18 ABORTED
        Transaction #17 ABORTED
        Transaction #16 ABORTED
        Transaction #4 ABORTED
        Transaction #2 ABORTED
        Transaction #10 ABORTED
                Prior transaction #9 RESTARTED as transaction #21, transfer $5: 4->8
                Prior transaction #1 RESTARTED as transaction #24, transfer $9: 3->6
                Prior transaction #7 RESTARTED as transaction #25, transfer $5: 3->8
                Prior transaction #6 RESTARTED as transaction #23, transfer $9: 8->6
                Prior transaction #8 RESTARTED as transaction #22, transfer $5: 8->2
                Prior transaction #14 RESTARTED as transaction #26, transfer $5: 6->5
                Prior transaction #11 RESTARTED as transaction #27, transfer $1: 5->5
Transaction #21 COMMITTED
Transaction #24 COMMITTED
        Transaction #23 ABORTED
        Transaction #22 ABORTED
        Transaction #25 ABORTED
Transaction #27 COMMITTED
        Transaction #26 ABORTED
                Prior transaction #18 RESTARTED as transaction #28, transfer $9: 2->1
Transaction #28 COMMITTED
                Prior transaction #17 RESTARTED as transaction #30, transfer $4: 1->1
                Prior transaction #19 RESTARTED as transaction #29, transfer $5: 5->3
Transaction #30 COMMITTED
                Prior transaction #4 RESTARTED as transaction #31, transfer $4: 4->1
Transaction #29 COMMITTED
Transaction #31 COMMITTED
                Prior transaction #2 RESTARTED as transaction #32, transfer $5: 4->0
                Prior transaction #20 RESTARTED as transaction #34, transfer $1: 7->6
Transaction #32 COMMITTED
                Prior transaction #25 RESTARTED as transaction #35, transfer $5: 3->8
                Prior transaction #26 RESTARTED as transaction #36, transfer $5: 6->5
                Prior transaction #22 RESTARTED as transaction #37, transfer $5: 8->2
Transaction #34 COMMITTED
                Prior transaction #23 RESTARTED as transaction #38, transfer $9: 8->6
Transaction #37 COMMITTED
        Transaction #35 ABORTED
        Transaction #36 ABORTED
        Transaction #38 ABORTED
                Prior transaction #16 RESTARTED as transaction #39, transfer $3: 9->0
                Prior transaction #12 RESTARTED as transaction #33, transfer $5: 9->2
Transaction #39 COMMITTED
        Transaction #33 ABORTED
                Prior transaction #10 RESTARTED as transaction #40, transfer $3: 9->8
Transaction #40 COMMITTED
                Prior transaction #36 RESTARTED as transaction #41, transfer $5: 6->5
                Prior transaction #38 RESTARTED as transaction #43, transfer $9: 8->6
Transaction #41 COMMITTED
                Prior transaction #35 RESTARTED as transaction #42, transfer $5: 3->8
        Transaction #43 ABORTED
                Prior transaction #33 RESTARTED as transaction #44, transfer $5: 9->2
Transaction #42 COMMITTED
Transaction #44 COMMITTED
                Prior transaction #43 RESTARTED as transaction #45, transfer $9: 8->6
Transaction #45 COMMITTED
============================================================= WE ARE DONE, SHUTTING DOWN =============================================================
```
