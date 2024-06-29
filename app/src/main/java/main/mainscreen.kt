package main

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.englishsoft.NavItemstate
import com.example.englishsoft.R
import kotlinx.coroutines.launch

@Composable
fun mainpagearrange(
    imageid: Array<Int>,
    circleimage2: Array<Int>,
    textcircle2: Array<String>,
    imageslide: List<Int>,
    circleimage: Array<Int>,
    textcircle: Array<String>,
    navController: NavController,

    ) {
    LazyColumn() {
        item { imageslider(imageslide) }
        item { rowlist(imageid, navController) }
        item { circleshapefirstrow(circleimage, textcircle, navController) }
        item { circleshapesecondrow(circleimage2, textcircle2, navController) }
        item { addvertisement() }
    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun searchbox() {
    var input by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(3.dp, Color.Blue)
            .height(50.dp), contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(value = input,
            onValueChange = { text -> input = text },
            label = {
                Box(
                    modifier=Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                )
                {
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Black))
                            {
                                append(stringResource(id = R.string.search))
                                withStyle(
                                    style = SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Blue
                                    )
                                ) {
                                    append(stringResource(id = R.string.softname))
                                }
                            }
                        },
                    )
                }
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search, contentDescription = "search"
                )
            },
            singleLine = true,
            modifier = Modifier.height(50.dp)

        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun imageslider(imageslide: List<Int>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(15.dp)
    ) {
        val pageCount = remember { mutableStateOf(imageslide.size) }
        val pagerState = rememberPagerState(
            initialPage = 0,
            pageCount = { pageCount.value }
        )

        Box(modifier = Modifier.fillMaxSize()) {
            HorizontalPager(state = pagerState) { currentPage ->
                Image(
                    painter = painterResource(id = imageslide[currentPage]),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { },
                    contentScale = ContentScale.FillBounds
                )
            }
        }


    }
}

@Composable
fun rowlist(imageid: Array<Int>, navController: NavController) {
    val imageindex = imageid.size
    LazyRow() {
        items(imageindex) { it ->
            rowitems(
                modifier = Modifier,
                itemeindex = it,
                painter = imageid,
                navController
            )
        }
    }
}

@Composable
fun rowitems(
    modifier: Modifier.Companion,
    itemeindex: Int,
    painter: Array<Int>,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .size(200.dp)
            .padding(10.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = painter[itemeindex]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        when (itemeindex) {
                            0 -> navController.navigate("kidssongscreen")
                            1 -> navController.navigate("englishsongscreen")
                            2 -> navController.navigate("proverbscreen")
                            3 -> navController.navigate("grammerscreen")
                            4 -> navController.navigate("cart oonscreen")
                            5 -> navController.navigate("extrascreen")
                        }
                    },
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun circleshapefirstrow(
    circleimage: Array<Int>,
    textcircle: Array<String>,
    navController: NavController
) {
    val circleimageid = (circleimage.size)
    val textcircleid = textcircle.size
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        circleimage.forEach { circleimageid ->
            Image(painter = painterResource(id = circleimageid),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
                    .clickable {
                        when (circleimageid) {
                            circleimage[0] -> navController.navigate("tensescreen")
                            circleimage[1] -> navController.navigate("adjectivescreen")
                            circleimage[2] -> navController.navigate("nounscreen")
                        }
                    })
        }

    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        textcircle.forEach { textcircleid ->
            Text(text = textcircleid)
        }
    }
}

@Composable
fun circleshapesecondrow(
    circleimage2: Array<Int>,
    textcircle2: Array<String>,
    navController: NavController
) {
    val textcircleid = textcircle2.size
    Spacer(modifier = Modifier.height(5.dp))
    val circleimageid = (circleimage2.size)
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        circleimage2.forEach { circleimageid ->
            Image(painter = painterResource(id = circleimageid),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
                    .clickable {
                        when (circleimageid) {
                            circleimage2[0] -> navController.navigate("schoolscreen")
                            circleimage2[1] -> navController.navigate("toefelscreen")
                            circleimage2[2] -> navController.navigate("ieltsscreen")
                        }
                    })
        }

    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        textcircle2.forEach { textcircleid ->
            Text(text = textcircleid)
        }
    }
}

@Composable
fun addvertisement() {
    Box(
        Modifier.height(250.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.add), contentDescription = "ADD",
            Modifier.fillMaxSize()
        )
    }


}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainscreen(
    imageid: Array<Int>,
    circleimage2: Array<Int>,
    textcircle2: Array<String>,
    imageslide: List<Int>,
    circleimage: Array<Int>,
    textcircle: Array<String>,
    navController: NavController,
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val items = listOf(
        NavItemstate(
            title = "Home",
            selectedicon = Icons.Filled.Home,
            unselectedicon = Icons.Outlined.Home,
            hasbage = false,
            badgenumber = 0
        ),
        NavItemstate(
            title = "History",
            selectedicon = Icons.Filled.List,
            unselectedicon = Icons.Outlined.List,
            hasbage = false,
            badgenumber = 0
        ),
        NavItemstate(
            title = "about us",
            selectedicon = Icons.Filled.Info,
            unselectedicon = Icons.Outlined.Info,
            hasbage = true,
            badgenumber = 1
        )
    )
    val coroutineScope = rememberCoroutineScope()
    var bottcontrolstate by rememberSaveable {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { searchbox() },
                Modifier
                    .padding(3.dp)
                    .clip(RoundedCornerShape(20.dp)),
                navigationIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch {
                            if (drawerState.isClosed) {
                                drawerState.open()
                            } else {
                                drawerState.close()
                            }
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
                    }
                },

                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        // Icon(imageVector = Icons.Default.Favorite, contentDescription = "favorite")
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "buy"
                        )

                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.White,
                    navigationIconContentColor = Color.Blue, actionIconContentColor = Color.Blue
                )
            )

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                Modifier.background(Color.Blue, CircleShape)
            ) {
                Icon(imageVector = Icons.Default.Email, contentDescription = "email")
            }

        },
        bottomBar = {
            NavigationBar(
                Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .height(70.dp) // ,containerColor= Color.Blue
            ) {
                items.forEachIndexed { index, items ->
                    NavigationBarItem(
                        selected = (bottcontrolstate == index),
                        onClick = {
                            // (bottcontrolstate = index)
                            when (index) {
                                0 -> navController.navigate("maninscreen")
                                1 -> navController.navigate("historyscreen")
                                2 -> navController.navigate("aboutscreen")
                            }
                        },
                        icon = {
                            BadgedBox(badge = {
                                if (items.hasbage) Badge {}
                                if (items.badgenumber != 0) Badge {
                                    Text(text = "${items.badgenumber}")
                                }
                            }) {
                                Icon(
                                    imageVector = if (bottcontrolstate == index) items.selectedicon
                                    else items.unselectedicon,
                                    contentDescription = items.title
                                )
                            }
                        },
                        label = {
                            Text(text = items.title)

                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Blue,
                            unselectedIconColor = Color.Blue,
                            indicatorColor = Color.LightGray
                        )
                    )


                }
            }

        },


        )

    { contentPading ->
        Column(
            Modifier
                .padding(contentPading)
                .fillMaxSize()
        ) {
            ModalNavigationDrawer(
                drawerContent = {
                    ModalDrawerSheet {
                        Text("Drawer title", modifier = Modifier.padding(16.dp))
                        Divider()
                        NavigationDrawerItem(
                            label = { Text(text = "Drawer Item") },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        // ...other drawer items
                    }
                },
                drawerState = drawerState
            )
            {
                mainpagearrange(
                    imageid,
                    circleimage2,
                    textcircle2,
                    imageslide,
                    circleimage,
                    textcircle,
                    navController
                )
            }

        }
    }
}